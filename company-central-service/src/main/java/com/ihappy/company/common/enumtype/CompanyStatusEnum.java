package com.ihappy.company.common.enumtype;

/**
 * Created by sunjd on 2018/3/30.
 */
public enum CompanyStatusEnum {
    DISABLED(0,"已禁用"),
    ENABLED(1,"使用中");

    private Integer key;

    private String value;

    private CompanyStatusEnum(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    private CompanyStatusEnum(Integer key){
        this.key = key;
    }

    public static CompanyStatusEnum getTbcpStatusEnum(Integer key) {
        for(CompanyStatusEnum x: CompanyStatusEnum.values()) {
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
