package com.ihappy.partner.infrastructure.service.inside.impl;

import com.ihappy.company.exception.CompanyException;
import com.ihappy.communal.infrastructure.util.CompanyLoggerUtil;
import com.ihappy.communal.infrastructure.util.DistributedPrimaryKeyFactory;
import com.ihappy.company.domain.bo.trade.PayJournalBO;
import com.ihappy.partner.common.constans.PartnerConstants;
import com.ihappy.partner.common.enumtype.Partner.PartnerArrearsTypeEnum;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.common.enumtype.partner.PartnerArrearsOperateTypeEnum;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.dbdo.BaseinfoPartnerArrearsOrder;
import com.ihappy.partner.domain.model.model.PartnerArrearsOrderModel;
import com.ihappy.partner.infrastructure.repo.mybatis.mapper.BaseinfoCompanyPartnerMapper;
import com.ihappy.partner.infrastructure.repo.mybatis.mapper.BaseinfoPartnerArrearsOrderMapper;
import com.ihappy.partner.infrastructure.service.inside.PartnerArrearsOrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by sunjd on 2018/4/18.
 */
public class PartnerArrearsOrderServiceImpl implements PartnerArrearsOrderService {
    private final static Logger logger = CompanyLoggerUtil.getLogger();

    @Autowired
    private BaseinfoPartnerArrearsOrderMapper baseinfoPartnerArrearsOrderMapper;

    @Autowired
    private BaseinfoCompanyPartnerMapper baseinfoCompanyPartnerMapper;

    @Autowired
    private TransactionTemplate companyTransactionTemplate;

    @Override
    public Long addPartnerArrearsOrder(PartnerArrearsOrderModel model) {
        BaseinfoPartnerArrearsOrder order = model.getDO();
        //判断修改后余额是否小于0
        if (PartnerArrearsOperateTypeEnum.PREPAID_DEPOSIT.getKey().equals(order.getType())) {
            BaseinfoCompanyPartner partner = baseinfoCompanyPartnerMapper.selectByPrimaryKey(order.getPartnerId());
            if (order.getMoney() * PartnerArrearsTypeEnum.getEnum(order.getIncomeType()).getValue() + partner.getPrepaidDeposit() < 0) {
                throw new CompanyException(PartnerErrorCodeEnum.
                        PREPAID_DEPOSIT_LESS_THEN_ZERO.getErrCode(),
                        PartnerErrorCodeEnum.PREPAID_DEPOSIT_LESS_THEN_ZERO.getErrMsg());
            }
        }
        order.setOrderId(DistributedPrimaryKeyFactory.generatePartnerArrearsOrderId(order.getCompId()));
        companyTransactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                int res = 0;
                try {
                    res = baseinfoPartnerArrearsOrderMapper.insertSelective(order);
                } catch (DuplicateKeyException e) {
                    logger.error(e.getMessage(), e);
                }
                if (res != 1) {
                    throw new CompanyException(PartnerErrorCodeEnum.
                            ADD_PARTNER_ARREARS_ERROR.getErrCode(),
                            PartnerErrorCodeEnum.ADD_PARTNER_ARREARS_ERROR.getErrMsg());
                }
                updatePartnerArrearsByOrder(order);
                return null;
            }
        });
        return order.getOrderId();
    }

    private void updatePartnerArrearsByOrder(BaseinfoPartnerArrearsOrder order) {
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        baseinfoCompanyPartner.setCompId(order.getCompId());
        baseinfoCompanyPartner.setPartnerId(order.getPartnerId());
        baseinfoCompanyPartner.setUpdatedAt(order.getUpdatedAt());
        if (PartnerArrearsOperateTypeEnum.PREPAID_DEPOSIT.getKey().equals(order.getType())) {
            baseinfoCompanyPartner.setPrepaidDeposit(order.getMoney() * PartnerArrearsTypeEnum.getEnum(order.getIncomeType()).getValue());
            int res1 = baseinfoCompanyPartnerMapper.updatePartnerArrearsByOrder(baseinfoCompanyPartner);
            if (res1 != 1) {
                throw new CompanyException(PartnerErrorCodeEnum.
                        UPDATE_PARTNER_PREPAID_DEPOSIT_ERROR.getErrCode(),
                        PartnerErrorCodeEnum.UPDATE_PARTNER_PREPAID_DEPOSIT_ERROR.getErrMsg());
            }
        } else {
            baseinfoCompanyPartner.setPartnerArrears(order.getMoney() * PartnerArrearsTypeEnum.getEnum(order.getIncomeType()).getValue());
            int res1 = baseinfoCompanyPartnerMapper.updatePartnerArrearsByOrder(baseinfoCompanyPartner);
            if (res1 != 1) {
                throw new CompanyException(PartnerErrorCodeEnum.
                        UPDATE_PARTNER_ARREARS_ERROR.getErrCode(),
                        PartnerErrorCodeEnum.UPDATE_PARTNER_ARREARS_ERROR.getErrMsg());
            }
        }
    }

    @Override
    public Boolean handlePayJournal(PayJournalBO payJournalBO) {
        // 先查询表中有无数据
        BaseinfoPartnerArrearsOrder existArrearsOrder
                = baseinfoPartnerArrearsOrderMapper.selectByPayJournal(payJournalBO.acquireArrearsQueryParam());
        // 没数据或已删除,并且支付流水没删除,处理欠款或预存款
        if ((existArrearsOrder == null || existArrearsOrder.getIsDeleted()) && !payJournalBO.getIsDeleted()) {
            if (existArrearsOrder != null) {
                baseinfoPartnerArrearsOrderMapper.deleteByPrimaryKey(existArrearsOrder.getOrderId());
            }
            addPartnerArrearsOrder(payJournalBO.acquireInsertPartnerArrearsOrderModel());
            return true;
        }
        // 没数据或已删除,并且支付流水也删除,不作处理
        if ((existArrearsOrder == null || existArrearsOrder.getIsDeleted()) && payJournalBO.getIsDeleted()) {
            return true;
        }
        // 有数据,判断支付流水是否为删除状态,未删除状态,说明之前已做过处理,现在不做处理
        if (!payJournalBO.getIsDeleted()) {
            return true;
        }
        // 有数据,判断支付流水是否为删除状态,删除状态, 做处理, 并且删除数据
        if(payJournalBO.getIsDeleted()){
            // 删除记录
            existArrearsOrder.setIsDeleted(true);
            baseinfoPartnerArrearsOrderMapper.updateByPrimaryKeySelective(existArrearsOrder);
            // 回滚partner表
            switchIncomeType(existArrearsOrder);
            updatePartnerArrearsByOrder(existArrearsOrder);
            return true;
        }
        return false;
    }

    /**
        * @Description: 切换收入类型,用来回滚欠款和预存款
        * @Param:
        * @return:
        * @Author: zhangtengpo
        * @Date: 18-8-27 下午7:23
        */
    private void switchIncomeType(BaseinfoPartnerArrearsOrder order) {
        if(order.getIncomeType().equals(PartnerConstants.INCOME_TYPE_DECREASE)){
            order.setIncomeType(PartnerConstants.INCOME_TYPE_INCREASE);
            return;
        }
        if(order.getIncomeType().equals(PartnerConstants.INCOME_TYPE_INCREASE)){
            order.setIncomeType(PartnerConstants.INCOME_TYPE_DECREASE);
            return;
        }
    }
}
