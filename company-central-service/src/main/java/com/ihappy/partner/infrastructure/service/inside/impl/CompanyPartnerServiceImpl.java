package com.ihappy.partner.infrastructure.service.inside.impl;

import com.google.common.collect.Lists;
import com.ihappy.common.util.CollectionUtil;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.communal.infrastructure.service.outside.trade.StatisticsReadService;
import com.ihappy.communal.infrastructure.util.DistributedPrimaryKeyFactory;
import com.ihappy.common.util.DateUtil;
import com.ihappy.partner.common.util.RedisTool;
import com.ihappy.company.common.enumtype.*;
import com.ihappy.company.common.utils.CompanyInfoUtil;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.partner.common.constans.PartnerConstants;
import com.ihappy.partner.common.enumtype.Partner.CompanyPartnerNameEnum;
import com.ihappy.partner.common.enumtype.Partner.CompanyPartnerTypeEnum;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.domain.bo.partner.PartnerBO;
import com.ihappy.partner.domain.bo.partner.PartnerMobileIsRepetitionBO;
import com.ihappy.partner.domain.bo.partner.QueryPartnerBO;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.dto.request.partner.ProviderInfoInsideQueryReqDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.domain.model.factory.PartnerArrearsOrderFactory;
import com.ihappy.partner.domain.model.model.CompanyPartnerModel;
import com.ihappy.partner.domain.model.model.PartnerArrearsOrderModel;
import com.ihappy.partner.infrastructure.repo.mybatis.mapper.BaseinfoCompanyPartnerMapper;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import com.ihappy.partner.infrastructure.service.inside.PartnerArrearsOrderService;
import com.ihappy.partner.infrastructure.util.PartnerUtil;
import com.ihappy.trade.domain.dto.request.order.OrderStatisticReqDTO;
import com.ihappy.trade.domain.dto.response.order.OrderStatisticRespDTO;
import com.ihappy.trade.domain.mq.OrderBaseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.transform;

/**
 * Created by sunjd on 2018/4/3.
 */
public class CompanyPartnerServiceImpl implements CompanyPartnerService {
    @Autowired
    BaseinfoCompanyPartnerMapper baseinfoCompanyPartnerMapper;

    @Autowired
    private PartnerArrearsOrderService partnerArrearsOrderService;

    @Autowired
    private StatisticsReadService statisticsReadService;

    @Override
    public CompanyPartnerModel addPartner(CompanyPartnerModel companyPartnerModel) {
        if (companyPartnerModel == null || companyPartnerModel.getDO() == null) {
            throw new CompanyException(PartnerErrorCodeEnum.
                    PARTNER_IS_NULL.getErrCode(),
                    PartnerErrorCodeEnum.PARTNER_IS_NULL.getErrMsg());
        }
        if (companyPartnerModel.getDO().getCompId() == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }

        //客户和零售会员，partner_name和partner_link_man保持一致
        PartnerUtil.fillCustomerPartnerOrPartnerLinkMan(companyPartnerModel.getDO());

        Long partnerId = DistributedPrimaryKeyFactory.generateCompanyPartnerId(companyPartnerModel.getDO().getCompId());
        companyPartnerModel.getDO().setPartnerId(partnerId);
        Long partnerArrears = companyPartnerModel.getDO().getPartnerArrears();
        companyPartnerModel.getDO().setPartnerArrears(null);
        if (companyPartnerModel.getDO().getPartnerType().equals(CompanyPartnerTypeEnum.RETAIL_CUSTOMER.getKey())) {
            companyPartnerModel.getDO().setMemberNo(partnerId.toString());
        }
        Integer res = baseinfoCompanyPartnerMapper.insertSelective(companyPartnerModel.getDO());
        if (res != 1) {
            throw new CompanyException(PartnerErrorCodeEnum.
                    ADD_PARTNER_ERROR.getErrCode(),
                    PartnerErrorCodeEnum.ADD_PARTNER_ERROR.getErrMsg());
        }
        //初始化欠款
        companyPartnerModel.getDO().setPartnerArrears(partnerArrears);
        if (companyPartnerModel.getDO().getPartnerArrears() != null && companyPartnerModel.getDO().getPartnerArrears() != 0) {
            PartnerArrearsOrderModel order = PartnerArrearsOrderFactory.baseinfoCompanyPartnerToModel(companyPartnerModel.getDO());
            partnerArrearsOrderService.addPartnerArrearsOrder(order);
        }

        return companyPartnerModel;
    }

    @Override
    public Integer updatePartner(BaseinfoCompanyPartner baseinfoCompanyPartner) {
        return baseinfoCompanyPartnerMapper.updatePartnerInfo(baseinfoCompanyPartner);
    }

    @Override
    public Integer updateProvider(BaseinfoCompanyPartner baseinfoCompanyPartner) {
        isCanEdit(baseinfoCompanyPartner);
        if (baseinfoCompanyPartner.getPartnerArrears() != null && baseinfoCompanyPartner.getPartnerArrears() != 0) {
            PartnerArrearsOrderModel order = PartnerArrearsOrderFactory.baseinfoCompanyPartnerToModel(baseinfoCompanyPartner);
            partnerArrearsOrderService.addPartnerArrearsOrder(order);
        }
        return baseinfoCompanyPartnerMapper.updatePartnerInfo(baseinfoCompanyPartner);
    }

    @Override
    public List<BaseinfoCompanyPartner> queryFavorList(BaseinfoCompanyPartner baseinfoCompanyPartner, Integer limit) {
        return baseinfoCompanyPartnerMapper.selectFavorByLimit(baseinfoCompanyPartner, limit);
    }

    @Override
    public List<BaseinfoCompanyPartner> queryLastContactList(BaseinfoCompanyPartner baseinfoCompanyPartner, Integer limit) {
        return baseinfoCompanyPartnerMapper.selectLastContactByLimit(baseinfoCompanyPartner, limit);
    }

    @Override
    public List<CompanyPartnerModel> queryListByPartnerLevelId(Long partnerLevelId) {
        BaseinfoCompanyPartner param = new BaseinfoCompanyPartner();
        param.setPartnerLevelId(partnerLevelId);
        List<BaseinfoCompanyPartner> baseinfoCompanyPartners = baseinfoCompanyPartnerMapper.selectListByPartnerLevelId(param);
        return transform(baseinfoCompanyPartners, (baseinfoCompanyPartner) -> new CompanyPartnerModel(baseinfoCompanyPartner));
    }

    @Override
    public Integer queryCountByPartnerLevelId(Long partnerLevelId) {
        BaseinfoCompanyPartner param = new BaseinfoCompanyPartner();
        param.setPartnerLevelId(partnerLevelId);
        return baseinfoCompanyPartnerMapper.selectCountByPartnerLevelId(param);
    }

    @Override
    public CompanyPartnerModel getProviderInfoInsideQuery(ProviderInfoInsideQueryReqDTO queryReqDTO) {
        BaseinfoCompanyPartner baseinfoCompanyPartner = baseinfoCompanyPartnerMapper.getProviderInfoInsideQuery(queryReqDTO);
        if (baseinfoCompanyPartner == null) {
            return null;
        }
        return new CompanyPartnerModel(baseinfoCompanyPartner);
    }

    @Override
    public Integer addRetailCustomer(CompanyPartnerModel partner) {
        if (partner.getDO().getMobile() != null) {
            BaseinfoCompanyPartner param = new BaseinfoCompanyPartner();
            param.setMobile(partner.getDO().getMobile());
            param.setCompId(partner.getDO().getCompId());
            param.setIsDeleted(0);
            List<BaseinfoCompanyPartner> old = baseinfoCompanyPartnerMapper.selectSelective(param);
            if (old != null && old.size() > 0) {
                throw new CompanyException(PartnerErrorCodeEnum.
                        PARTNER_MOBILE_REPETITION.getErrCode(),
                        PartnerErrorCodeEnum.PARTNER_MOBILE_REPETITION.getErrMsg());
            }
        }
        //客户和零售会员，partner_name和partner_link_man保持一致
        PartnerUtil.fillCustomerPartnerOrPartnerLinkMan(partner.getDO());
        return baseinfoCompanyPartnerMapper.insertSelective(partner.getDO());
    }

    @Override
    public Integer updateRetailCustomer(CompanyPartnerModel partner) {
        if (partner.getDO().getMobile() != null) {
            BaseinfoCompanyPartner param = new BaseinfoCompanyPartner();
            param.setMobile(partner.getDO().getMobile());
            param.setCompId(partner.getDO().getCompId());
            param.setIsDeleted(0);
            List<BaseinfoCompanyPartner> old = baseinfoCompanyPartnerMapper.selectSelective(param);
            if (old != null && old.size() > 1) {
                throw new CompanyException(PartnerErrorCodeEnum.
                        PARTNER_MOBILE_REPETITION.getErrCode(),
                        PartnerErrorCodeEnum.PARTNER_MOBILE_REPETITION.getErrMsg());
            } else if (old != null && old.size() == 1) {
                if (!old.get(0).getPartnerId().equals(partner.getDO().getPartnerId())) {
                    throw new CompanyException(PartnerErrorCodeEnum.
                            PARTNER_MOBILE_REPETITION.getErrCode(),
                            PartnerErrorCodeEnum.PARTNER_MOBILE_REPETITION.getErrMsg());
                }
            }
        }
        //客户和零售会员，partner_name和partner_link_man保持一致
        PartnerUtil.fillCustomerPartnerOrPartnerLinkMan(partner.getDO());
        return baseinfoCompanyPartnerMapper.updatePartnerInfo(partner.getDO());
    }


    @Override
    public CompanyPartnerModel queryPartner(CompanyPartnerModel partner) {
        BaseinfoCompanyPartner res = baseinfoCompanyPartnerMapper.selectPartner(partner.getDO());
        if (res == null) {
            return null;
        }
        //客户和零售会员，partner_name和partner_link_man保持一致
        PartnerUtil.fillCustomerPartnerOrPartnerLinkMan(res);
        return new CompanyPartnerModel(res);
    }

    @Override
    public List<CompanyPartnerModel> queryPartnerPageByCondition(CompanyPartnerModel partner) {
        List<BaseinfoCompanyPartner> resList = baseinfoCompanyPartnerMapper.selectPartnerPageByCondition(partner.getDO());
        if (CollectionUtils.isEmpty(resList)) {
            return new ArrayList<>();
        }
        //客户和零售会员，partner_name和partner_link_man保持一致
        PartnerUtil.fillCustomerPartnerOrPartnerLinkMan(resList);
        return transform(resList, (obj) -> new CompanyPartnerModel(obj));
    }

    @Override
    public Integer queryPartnerPageByConditionCount(CompanyPartnerModel partner) {
        Integer res = baseinfoCompanyPartnerMapper.selectPartnerPageByConditionCount(partner.getDO());
        return res == null ? 0 : res;
    }

    @Override
    public List<CompanyPartnerModel> queryPartnerPageByCompId(QueryPartnerBO queryPartnerBO) {
        List<BaseinfoCompanyPartner> partnerList = baseinfoCompanyPartnerMapper.selectPartnerPageByCompId(queryPartnerBO);
        List<CompanyPartnerModel> modelList = new ArrayList<>();
        for (BaseinfoCompanyPartner baseinfoCompanyPartner : partnerList) {
            modelList.add(new CompanyPartnerModel(baseinfoCompanyPartner));
        }
        return modelList;
    }

    @Override
    public Integer queryPartnerPageByCompIdCount(QueryPartnerBO queryPartnerBO) {
        Integer partnerCount = baseinfoCompanyPartnerMapper.selectPartnerPageByCompIdCount(queryPartnerBO);
        return partnerCount == null ? 0 : partnerCount;
    }

    @Override
    public Boolean addDefaultPartner(CompanyModel companyModel) {
        // 先查询当前公司是否有默认供应商和客户
        BaseinfoCompanyPartner queryParam = new BaseinfoCompanyPartner();
        queryParam.setIsDeleted(IsDeletedEnum.NOT_DELETED.getKey());
        queryParam.setCompId(companyModel.getDO().getCompId());
        List<BaseinfoCompanyPartner> partners = baseinfoCompanyPartnerMapper.selectSelective(queryParam);
        boolean hasDefaultSupplier = false;
        boolean hasDefaultCustomer = false;
        if (partners == null || partners.size() == 0) {  // 没有供应商和客户信息
            addDefaultSupplier(companyModel);
            addDefaultCustomer(companyModel);
            return true;
        }
        // 遍历所有partner, 判断名字是否是默认供应商和客户, 并且is_default是否是1
        for (BaseinfoCompanyPartner partner : partners) {
            if (!hasDefaultSupplier && CompanyPartnerTypeEnum.PROVIDER.getKey().equals(partner.getPartnerType())) {  // 供应商
                if (CompanyPartnerNameEnum.MY_FACTORY.getName().equals(partner.getPartnerName())
                        || CompanyPartnerNameEnum.DEFAULT_SUPPLIER.getName().equals(partner.getPartnerName())) {  // 名称为"我的工厂"或"默认供应商"
                    // 是否is_default为1 并且is_can_edit为1, 否就更新这两个字段
                    if (!partner.getIsDefault().equals(1) || !partner.getIsCanEdit().equals(1)) {
                        partner.setIsCanEdit(1);
                        partner.setIsDefault(1);
                        baseinfoCompanyPartnerMapper.forceUpdateByPrimaryKeySelective(partner);
                    }
                    hasDefaultSupplier = true;
                }
            } else if (!hasDefaultCustomer && CompanyPartnerTypeEnum.CUSTOMER.getKey().equals(partner.getPartnerType())) {  // 顾客
                if (CompanyPartnerNameEnum.DEFAULT_CUSTOMER.getName().equals(partner.getPartnerName())) {  // 名称为"散客"
                    // 是否is_default为1 并且is_can_edit为1, 否就更新这两个字段
                    if (!partner.getIsDefault().equals(1) || !partner.getIsCanEdit().equals(1)) {
                        partner.setIsCanEdit(1);
                        partner.setIsDefault(1);
                        baseinfoCompanyPartnerMapper.forceUpdateByPrimaryKeySelective(partner);
                    }
                    hasDefaultCustomer = true;
                }
            }
        }

        // 判断是否已经有默认供应商和客户 没有就新增默认供应商和客户
        if (!hasDefaultSupplier) {  // 没有默认供应商
            addDefaultSupplier(companyModel);
        }
        if (!hasDefaultCustomer) {  // 没有默认客户
            addDefaultCustomer(companyModel);
        }
        return true;
    }

    @Override
    public Boolean mobileIsRepetition(PartnerMobileIsRepetitionBO partnerMobileIsRepetitionBO) {
        String operate = partnerMobileIsRepetitionBO.getOperate();
        //操作类型为空按照添加情况判断
        if (StringUtils.isEmpty(operate)) {
            operate = BaseOperateEnum.ADD.getKey();
        }
        String mobile = partnerMobileIsRepetitionBO.getMobile();
        //电话为空 认为不重复
        if (StringUtils.isEmpty(mobile)) {
            return false;
        }
        Integer compId = partnerMobileIsRepetitionBO.getCompId();
        if (compId == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        Long partnerId = partnerMobileIsRepetitionBO.getPartnerId();
        Integer partnerType = partnerMobileIsRepetitionBO.getPartnerType();
        //添加
        if (operate.equals(BaseOperateEnum.ADD.getKey())) {
            BaseinfoCompanyPartner param = new BaseinfoCompanyPartner();
            param.setMobile(mobile);
            param.setCompId(compId);
            param.setPartnerType(partnerType);
            param.setIsDeleted(0);
            List<BaseinfoCompanyPartner> old = baseinfoCompanyPartnerMapper.selectSelective(param);
            if (old != null && old.size() > 0) {
                return true;
            }
        }
        //修改
        if (operate.equals(BaseOperateEnum.UPDATE.getKey())) {
            BaseinfoCompanyPartner param = new BaseinfoCompanyPartner();
            param.setMobile(mobile);
            param.setCompId(compId);
            param.setPartnerType(partnerType);
            param.setIsDeleted(0);
            List<BaseinfoCompanyPartner> old = baseinfoCompanyPartnerMapper.selectSelective(param);
            if (old != null && old.size() > 1) {
                return true;
            } else if (old != null && old.size() == 1) {
                if (!old.get(0).getPartnerId().equals(partnerId)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 是否可编辑
     *
     * @param partner
     */
    @Override
    public void isCanEdit(BaseinfoCompanyPartner partner) {
        BaseinfoCompanyPartner old = baseinfoCompanyPartnerMapper.selectByPrimaryKey(partner.getPartnerId());
        if (CanEditEnum.NOT_EDIT.getKey().equals(old.getIsCanEdit())) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    CAN_NOT_EDIT_ERROR.getErrCode(),
                    CompanyErrorCodeEnum.CAN_NOT_EDIT_ERROR.getErrMsg());
        }
    }

    @Override
    public PartnerBO findPartnerStatistics(BaseinfoCompanyPartner partner) {
        if (partner.getCompId() == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        return baseinfoCompanyPartnerMapper.selectPartnerStatistics(partner);
    }

    @Override
    public List<BaseinfoCompanyPartner> findPartnerCheckPage(Map<String, Object> map) {
        if (CollectionUtils.isEmpty(map)) {
            return new ArrayList<>();
        }
        if (map.get("compId") == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        return baseinfoCompanyPartnerMapper.selectPartnerCheckPage(map);
    }

    @Override
    public Integer findPartnerCheckCount(Map<String, Object> map) {
        if (CollectionUtils.isEmpty(map)) {
            return 0;
        }
        if (map.get("compId") == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_ID_IS_NULL.getErrMsg());
        }
        return baseinfoCompanyPartnerMapper.selectPartnerCheckPageCount(map);
    }

    @Override
    public Integer forceUpdatePartner(BaseinfoCompanyPartner partner) {
        if (partner == null) {
            return 0;
        }
        if (partner.getPartnerId() == null) {
            throw new CompanyException(PartnerErrorCodeEnum.
                    PARTNER_ID_IS_NULL.getErrCode(),
                    PartnerErrorCodeEnum.PARTNER_ID_IS_NULL.getErrMsg());
        }
        return baseinfoCompanyPartnerMapper.forceUpdateByPrimaryKeySelective(partner);
    }

    @Override
    public List<BaseinfoCompanyPartner> selectByCondition(BaseinfoCompanyPartner partner) {
        if (partner == null) {
            return new ArrayList<>();
        }
        if (partner.getCompId() == null && partner.getPartnerId() == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    ILLGAL_ARGUMENT.getErrCode(),
                    CompanyErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
        return baseinfoCompanyPartnerMapper.selectSelective(partner);
    }

    @Override
    public void updatePartnerStatistics(OrderBaseMessage message) {
        if (message == null) {
            return;
        }
        RedisTool.sadd(PartnerConstants.PARTNER_ORDER_STATISTIC_SET, message.getPartnerId() + "-" + message.getCompId() + "-" + message.getOrderType());
        Long startTime = System.currentTimeMillis();
        String requestId = UUID.randomUUID().toString().replaceAll("-", "");
        if (RedisTool.tryGetDistributedLock(PartnerConstants.PARTNER_ORDER_STATISTIC_KEY, requestId, PartnerConstants.PARTNER_ORDER_STATISTIC_KEY_TIME)) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    updatePartnerStatistics(requestId, startTime);
                }
            };
            new Thread(runnable, "UPDATE_PARTNER_STATISTICS_" + requestId).start();
        }
    }

    @Override
    public void updatePartnerStatistics(String requestId, Long startTime) {
        Set<String> partnerCompOrderIdSet = RedisTool.smove(PartnerConstants.PARTNER_ORDER_STATISTIC_SET, PartnerConstants.PARTNER_ORDER_STATISTIC_CALL_SET);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            String partnerCompOrderId = RedisTool.spop(PartnerConstants.PARTNER_ORDER_STATISTIC_CALL_SET);
            if (partnerCompOrderId == null) {
                break;
            }
            String[] partnerCompOrderIdArry = partnerCompOrderId.split("-");
            Long partnerId = Long.valueOf(partnerCompOrderIdArry[0]);
            Long compId = Long.valueOf(partnerCompOrderIdArry[1]);
            Integer orderType = Integer.valueOf(partnerCompOrderIdArry[2]);
            updatePartnerStatistics(partnerId, orderType, compId);
        }
        if (RedisTool.scard(PartnerConstants.PARTNER_ORDER_STATISTIC_SET) > 0) {
            partnerCompOrderIdSet = RedisTool.smove(PartnerConstants.PARTNER_ORDER_STATISTIC_SET, PartnerConstants.PARTNER_ORDER_STATISTIC_CALL_SET);
            Long endTime = System.currentTimeMillis();
            if ((endTime - startTime)/1000 > PartnerConstants.PARTNER_ORDER_STATISTIC_KEY_TIME) {
                if (RedisTool.tryGetDistributedLock(PartnerConstants.PARTNER_ORDER_STATISTIC_KEY, requestId, PartnerConstants.PARTNER_ORDER_STATISTIC_KEY_TIME)) {
                    updatePartnerStatistics(requestId, startTime);
                }
            } else {
                updatePartnerStatistics(requestId, startTime);
            }
        } else {
            RedisTool.releaseDistributedLock(PartnerConstants.PARTNER_ORDER_STATISTIC_KEY, requestId);
        }
    }

    @Override
    public void updatePartnerStatistics(Long partnerId, Integer orderType, Long compId) {
        OrderStatisticReqDTO orderStatisticReqDTO = new OrderStatisticReqDTO();
        orderStatisticReqDTO.setPartnerId(partnerId);
        orderStatisticReqDTO.setOrderType(orderType);
        orderStatisticReqDTO.setCompId(compId);
        orderStatisticReqDTO.setDueAmount(true);
        orderStatisticReqDTO.setOnTheWayNumber(true);
        orderStatisticReqDTO.setTotalNumber(true);
        orderStatisticReqDTO.setOrderCount(true);
        orderStatisticReqDTO.setDebtDate(true);
        orderStatisticReqDTO.setRefundTimes(true);
        OrderStatisticRespDTO statics = statisticsReadService.queryOrderStatisticsByPartner(orderStatisticReqDTO);
        if (statics != null) {
            Boolean needUpdate = (statics.getDueAmount() != null || statics.getOnTheWayNumber() != null ||
                    statics.getTotalNumber() != null || statics.getOrderCount() != null || statics.getDebtDate() != null
                    || statics.getRetailRefundTimes() != null);
            if (needUpdate) {
                BaseinfoCompanyPartner partner = BaseInfoCompanyPartnerFactory.orderStatisticRespDTO2BaseInfoCompanyPartner(statics);
                Integer num = forceUpdatePartner(partner);
            }
        }
    }

    @Override
    public List<CompanyPartnerModel> checkMobileIsOrNotRepeat(QueryPartnerBO queryPartnerBO) {
        List<BaseinfoCompanyPartner>  baseinfoCompanyPartners =baseinfoCompanyPartnerMapper.checkMobileIsOrNotRepeat(queryPartnerBO);
        if (CollectionUtil.isEmpty(baseinfoCompanyPartners)) {
            return Lists.newArrayList();
        }
        return baseinfoCompanyPartners.stream().map(CompanyPartnerModel::new).collect(Collectors.toList());
    }

    /**
     * @Description: 添加默认供应商
     * @Param:
     * @return:
     * @Author: zhangtengpo
     * @Date: 2018/5/30
     */
    private void addDefaultSupplier(CompanyModel companyModel) {
        String ctIds = companyModel.getDO().getCtIds();
        String[] ctIdArr = ctIds.split(",");
        boolean hasAddDefaultSupplier = false;
        for (String ctId : ctIdArr) {
            if (CompanyTypeEnum.FIRSST_LEVEL_WHOLESALER.getTypeCode().toString().equals(ctId)) {  // 一级供应商
                BaseinfoCompanyPartner defaultSupplier = generateDefaultPartner(companyModel.getDO(), CompanyPartnerTypeEnum.PROVIDER.getKey(), CompanyPartnerNameEnum.MY_FACTORY.getName());
                baseinfoCompanyPartnerMapper.insertSelective(defaultSupplier);
            } else if (!hasAddDefaultSupplier) {  // 二级供应商或零售商  并且未创建默认供应商
                BaseinfoCompanyPartner defaultSupplier = generateDefaultPartner(companyModel.getDO(), CompanyPartnerTypeEnum.PROVIDER.getKey(), CompanyPartnerNameEnum.DEFAULT_SUPPLIER.getName());
                hasAddDefaultSupplier = true;
                baseinfoCompanyPartnerMapper.insertSelective(defaultSupplier);
            }
        }
    }

    /**
     * @Description: 添加默认客户
     * @Param:
     * @return:
     * @Author: zhangtengpo
     * @Date: 2018/5/30
     */
    private void addDefaultCustomer(CompanyModel companyModel) {
        //零售 添加默认客户类型为 零售会员
        Integer partnerType = CompanyPartnerTypeEnum.CUSTOMER.getKey();
        if (CompanyInfoUtil.isRetail(companyModel.getDO().getCtIds())) {
            partnerType = CompanyPartnerTypeEnum.RETAIL_CUSTOMER.getKey();
        }
        BaseinfoCompanyPartner defaultCustomer = generateDefaultPartner(companyModel.getDO(), partnerType, CompanyPartnerNameEnum.DEFAULT_CUSTOMER.getName());
        baseinfoCompanyPartnerMapper.insertSelective(defaultCustomer);
    }

    private BaseinfoCompanyPartner generateDefaultPartner(BaseinfoCompany companyInfo, int partnerType, String partnerName) {
        BaseinfoCompanyPartner partner = new BaseinfoCompanyPartner();
        partner.setPartnerId(DistributedPrimaryKeyFactory.generateCompanyPartnerId(companyInfo.getCompId()));
        partner.setCompId(companyInfo.getCompId());
        partner.setCompName(companyInfo.getCompName());
        partner.setPartnerName(partnerName);
        partner.setPartnerLinkman(partnerName);
        partner.setPartnerType(partnerType);
        partner.setCreatedAt(DateUtil.getCurrentDate());
        partner.setUpdatedAt(DateUtil.getCurrentDate());
        partner.setCreatedPersonId(0L);
        partner.setUpdatedPersonId(0L);
        partner.setIsCanEdit(0);
        partner.setIsDefault(1);
        return partner;
    }

    @Override
    public List<BaseinfoCompanyPartner> selectPartner(BaseinfoCompanyPartner baseinfoCompanyPartner) {
        return baseinfoCompanyPartnerMapper.selectSelective(baseinfoCompanyPartner);
    }
}