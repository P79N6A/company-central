package com.ihappy.partner.common.enumtype.Partner;

/**
 * Created by sunjd on 2018/4/2.
 */
public enum  CompanyPartnerTypeEnum {
    PROVIDER(0,"供应商"),
    CUSTOMER(1,"客户"),
    RETAIL_CUSTOMER(2,"零售会员")
    ;

    private Integer key;

    private String value;

    private CompanyPartnerTypeEnum(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    private CompanyPartnerTypeEnum(Integer key){
        this.key = key;
    }

    public static CompanyPartnerTypeEnum getEnum(Integer key) {
        for(CompanyPartnerTypeEnum x: CompanyPartnerTypeEnum.values()) {
            if(x.getKey().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public Integer getKey(){
        return this.key;
    }

    public String getValue(){
        return this.value;
    }
}
