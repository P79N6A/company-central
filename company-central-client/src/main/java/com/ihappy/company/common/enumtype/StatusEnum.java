package com.ihappy.company.common.enumtype;

/**
 * Created by liuhc on 2018/7/12.
 */
public enum  StatusEnum {
    HEI(0,"黑名单"),
    BAI(1,"普通"),
    FOREVER(2,"白名单"),
    ;

    private Integer key;

    private String value;

    private StatusEnum(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    private StatusEnum(Integer key){
        this.key = key;
    }

    public static StatusEnum getTbcpNatureEnum(Integer key) {
        for(StatusEnum x: StatusEnum.values()) {
            if(x.getKey().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public static StatusEnum getTbcpNatureEnum(String value) {
        for(StatusEnum x: StatusEnum.values()) {
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

