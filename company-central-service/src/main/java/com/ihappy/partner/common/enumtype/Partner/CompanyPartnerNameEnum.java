package com.ihappy.partner.common.enumtype.Partner;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-05-30 15:43
 */
public enum CompanyPartnerNameEnum {
    MY_FACTORY("我的工厂"),
    DEFAULT_SUPPLIER("默认供应商"),
    DEFAULT_CUSTOMER("散客")
    ;

    private String name;

    private CompanyPartnerNameEnum(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
