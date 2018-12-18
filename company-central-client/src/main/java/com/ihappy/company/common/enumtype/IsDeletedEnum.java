package com.ihappy.company.common.enumtype;

/**
 * Created by sunjd on 2018/5/15.
 */
public enum  IsDeletedEnum {
    NOT_DELETED(0,"未删除"),
    DELETED(1,"已删除"),
    ;

    private Integer key;

    private String value;

    private IsDeletedEnum(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    private IsDeletedEnum(Integer key){
        this.key = key;
    }

    public static IsDeletedEnum getTbcpNatureEnum(Integer key) {
        for(IsDeletedEnum x: IsDeletedEnum.values()) {
            if(x.getKey().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public static IsDeletedEnum getTbcpNatureEnum(String value) {
        for(IsDeletedEnum x: IsDeletedEnum.values()) {
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
