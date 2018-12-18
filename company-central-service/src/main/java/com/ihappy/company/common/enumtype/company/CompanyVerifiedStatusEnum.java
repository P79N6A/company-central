package com.ihappy.company.common.enumtype.company;

/**
 * Created by sunjd on 2018/6/6.
 */
public enum CompanyVerifiedStatusEnum {
    UNVERIFIED(0,"未认证"),
    VERIFING(1,"待审核"),
    VERIFIED(2,"审核通过"),
    VERIFY_NOT_PASS(3,"审核不通过"),
    ;

    private Integer key;

    private String value;

    private CompanyVerifiedStatusEnum(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    private CompanyVerifiedStatusEnum(Integer key){
        this.key = key;
    }

    public static CompanyVerifiedStatusEnum getEnumByKey(Integer key) {
        for(CompanyVerifiedStatusEnum x: CompanyVerifiedStatusEnum.values()) {
            if(x.getKey().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public static CompanyVerifiedStatusEnum getEnumByValue(String value) {
        for(CompanyVerifiedStatusEnum x: CompanyVerifiedStatusEnum.values()) {
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
