package com.ihappy.partner.domain.model.factory;

import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.partner.common.enumtype.Partner.PartnerIncomeTypeEnum;
import com.ihappy.partner.domain.dbdo.BaseinfoPartnerArrearsOrder;
import com.ihappy.partner.domain.dto.request.partner.PartnerArrearsOrderAddReqDTO;
import com.ihappy.partner.domain.model.model.PartnerArrearsOrderModel;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.UUID;

/**
 * Created by sunjd on 2018/4/18.
 */
public class PartnerArrearsOrderFactory {
    public static PartnerArrearsOrderModel addReqDTOToModel(PartnerArrearsOrderAddReqDTO dto){
        BaseinfoPartnerArrearsOrder baseinfoPartnerArrearsOrder = new BaseinfoPartnerArrearsOrder();
        baseinfoPartnerArrearsOrder.setType(dto.getType());
        baseinfoPartnerArrearsOrder.setOrderNo(dto.getOrderNo());
        baseinfoPartnerArrearsOrder.setOrderType(dto.getOrderType() == null ?"":dto.getOrderType().toString());
        baseinfoPartnerArrearsOrder.setOrderNum(dto.getOrderNum());
        baseinfoPartnerArrearsOrder.setPartnerId(dto.getPartnerId());
        baseinfoPartnerArrearsOrder.setCompId(dto.getCompId());
        baseinfoPartnerArrearsOrder.setMoney(dto.getMoney());
        baseinfoPartnerArrearsOrder.setSourceType(0);
        baseinfoPartnerArrearsOrder.setIncomeType(dto.getIncomeType());
        baseinfoPartnerArrearsOrder.setCreatedAt(CompanyDateUtil.getDate14Long(dto.getCreateTime()));
        baseinfoPartnerArrearsOrder.setUpdatedAt(CompanyDateUtil.getDate14Long(dto.getUpdateTime()));
        baseinfoPartnerArrearsOrder.setCreatedPersonId(dto.getCreatedPersonId());
        baseinfoPartnerArrearsOrder.setUpdatedPersonId(dto.getCreatedPersonId());
        return new PartnerArrearsOrderModel(baseinfoPartnerArrearsOrder);
    }

    public static PartnerArrearsOrderModel baseinfoCompanyPartnerToModel(BaseinfoCompanyPartner partner){
        BaseinfoPartnerArrearsOrder order = new BaseinfoPartnerArrearsOrder();
        BeanUtils.copyProperties(partner,order);
        order.setSourceType(1);
        order.setCreatedAt(CompanyDateUtil.getDate14Long(new Date()));
        if(partner.getPartnerArrears() > 0){
            order.setMoney(partner.getPartnerArrears());
            order.setIncomeType(PartnerIncomeTypeEnum.EXPENDITURE.getKey());
        }else if(partner.getPartnerArrears() < 0){
            order.setMoney(partner.getPartnerArrears()*-1);
            order.setIncomeType(PartnerIncomeTypeEnum.INCOME.getKey());
        }
        order.setCreatedPersonId(partner.getUpdatedPersonId());
        order.setOrderNum(UUID.randomUUID().toString().replaceAll("-", ""));
        return new PartnerArrearsOrderModel(order);
    }
}
