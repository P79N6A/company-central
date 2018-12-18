package com.ihappy.partner.infrastructure.util;

import com.ihappy.common.util.StringUtil;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.common.enumtype.Partner.CompanyPartnerTypeEnum;

import java.util.List;

/**
 * Created by sunjd on 2018/6/18.
 * 客户/供应商/零售会员  工具类
 */
public class PartnerUtil {
    /**
     * 客户/零售会员，没有partnerLinkman 则设为 partnerName
     * @param obj
     */
    public static void  fillCustomerPartnerOrPartnerLinkMan(BaseinfoCompanyPartner obj){
        if (obj == null){
            return;
        }
        Boolean isCustomer = CompanyPartnerTypeEnum.RETAIL_CUSTOMER.getKey().equals(obj.getPartnerType()) || CompanyPartnerTypeEnum.CUSTOMER.getKey().equals(obj.getPartnerType());
        if (isCustomer){
            Boolean hasPartnerName = !(StringUtil.isBlank(obj.getPartnerName())) && StringUtil.isBlank(obj.getPartnerLinkman());
            if (hasPartnerName){
                obj.setPartnerLinkman(obj.getPartnerName());
            }
        }
    }
    /**
     * 客户/零售会员，没有partnerLinkman 则设为 partnerName
     * @param list
     */
    public static void  fillCustomerPartnerOrPartnerLinkMan(List<BaseinfoCompanyPartner> list){
        if (list == null){
            return;
        }
        for(BaseinfoCompanyPartner obj : list){
            Boolean isCustomer = CompanyPartnerTypeEnum.RETAIL_CUSTOMER.getKey().equals(obj.getPartnerType()) || CompanyPartnerTypeEnum.CUSTOMER.getKey().equals(obj.getPartnerType());
            if (isCustomer){
                if(StringUtil.isEmpty(obj.getPartnerLinkman())){
                    Boolean hasPartnerName = !(StringUtil.isBlank(obj.getPartnerName())) && StringUtil.isBlank(obj.getPartnerLinkman());
                    if (hasPartnerName){
                        obj.setPartnerLinkman(obj.getPartnerName());
                    }
                }

            }
        }
    }
}
