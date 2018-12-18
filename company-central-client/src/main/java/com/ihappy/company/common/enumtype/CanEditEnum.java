package com.ihappy.company.common.enumtype;

/**
 * Created by sunjd on 2018/6/18.
 */
public enum CanEditEnum {
    NOT_EDIT(0, "不可编辑"),
    CAN_EDIT(1, "可编辑"),
    ;

    private Integer key;

    private String value;

    private CanEditEnum(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    private CanEditEnum(Integer key){
        this.key = key;
    }

    public static CanEditEnum getEnumByKey(Integer key) {
        for(CanEditEnum x: CanEditEnum.values()) {
            if(x.getKey().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public static CanEditEnum getEnumByValue(String value) {
        for(CanEditEnum x: CanEditEnum.values()) {
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
