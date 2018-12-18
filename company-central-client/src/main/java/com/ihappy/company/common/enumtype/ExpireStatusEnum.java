package com.ihappy.company.common.enumtype;

/**
 * Created by liuhc on 2018/7/12.
 */
public enum  ExpireStatusEnum {
    PAY(0,"体验"),
    FOREVER(1,"付费"),
    ;

    private Integer key;

    private String value;

    private ExpireStatusEnum(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    private ExpireStatusEnum(Integer key){
        this.key = key;
    }

    public static ExpireStatusEnum getTbcpNatureEnum(Integer key) {
        for(ExpireStatusEnum x: ExpireStatusEnum.values()) {
            if(x.getKey().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public static ExpireStatusEnum getTbcpNatureEnum(String value) {
        for(ExpireStatusEnum x: ExpireStatusEnum.values()) {
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
