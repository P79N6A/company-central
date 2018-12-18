package com.ihappy.company.common.enumtype;

/**
 * Created by sunjd on 2018/3/30.
 */
public enum CompanyVerifiedEnum {
    PENDING(0,"待审核"),
    PASSED(1,"审核通过"),
    NOT_PASSED(2,"审核不通过");

    private Integer key;

    private String value;

    private CompanyVerifiedEnum(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    private CompanyVerifiedEnum(Integer key){
        this.key = key;
    }

    public static CompanyVerifiedEnum getTbcpVerifiedEnum(Integer key) {
        for(CompanyVerifiedEnum x: CompanyVerifiedEnum.values()) {
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
