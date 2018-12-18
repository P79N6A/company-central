package com.ihappy.company.common.enumtype.company;

/**
 * Created by sunjd on 2018/5/30.
 * 门店、仓库是否为默认标识
 */
public enum IsDefaultEnum {
    NOT_DEFAULT(0,"非默认"),
    DEFAULT(1,"默认");

    private Integer key;

    private String value;

    private IsDefaultEnum(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    private IsDefaultEnum(Integer key){
        this.key = key;
    }

    public static IsDefaultEnum getEnumByKey(Integer key) {
        for(IsDefaultEnum x: IsDefaultEnum.values()) {
            if(x.getKey().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public static IsDefaultEnum getEnumByValue(String value) {
        for(IsDefaultEnum x: IsDefaultEnum.values()) {
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
