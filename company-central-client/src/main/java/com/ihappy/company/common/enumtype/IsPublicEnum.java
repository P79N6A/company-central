package com.ihappy.company.common.enumtype;

/**
 * Created by sunjd on 2018/7/26.
 * isPublic标识枚举类
 */
public enum IsPublicEnum {
    NOT_PUBLIC(0,"否"),
    PUBLIC(1,"是"),
    ;

    private Integer key;

    private String value;

    private IsPublicEnum(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    private IsPublicEnum(Integer key){
        this.key = key;
    }

    public static IsPublicEnum getTbcpNatureEnum(Integer key) {
        for(IsPublicEnum x: IsPublicEnum.values()) {
            if(x.getKey().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public static IsPublicEnum getTbcpNatureEnum(String value) {
        for(IsPublicEnum x: IsPublicEnum.values()) {
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
