package com.ihappy.company.common.enumtype;

/**
 * Created by sunjd on 2018/5/15.
 */
public enum  SexEnum {
    SECRECY(0,"保密"),
    MAN(1,"男"),
    WOMAN(2,"女"),
    ;

    private Integer key;

    private String value;

    private SexEnum(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    private SexEnum(Integer key){
        this.key = key;
    }

    public static SexEnum getEnum(Integer key) {
        for(SexEnum x: SexEnum.values()) {
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
