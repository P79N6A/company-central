package com.ihappy.company.common.enumtype;

/**
 * Created by sunjd on 2018/3/29.
 */
public enum CompanyNatureEnum {
    ENTERPRISE(1,"企业单位"),
    SELF_EMPLOY(2,"个体经营");

    private Integer key;

    private String value;

    private CompanyNatureEnum(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    private CompanyNatureEnum(Integer key){
        this.key = key;
    }

    public static CompanyNatureEnum getTbcpNatureEnum(Integer key) {
        for(CompanyNatureEnum x: CompanyNatureEnum.values()) {
            if(x.getKey().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public static CompanyNatureEnum getTbcpNatureEnum(String value) {
        for(CompanyNatureEnum x: CompanyNatureEnum.values()) {
            if(x.getValue().equals(value)) {
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
