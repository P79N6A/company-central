package com.ihappy.store.common.enumtype.weshop;

/**
 * Created by sunjd on 2018/7/4.
 * 微商铺访问 UID 类型枚举类
 */
public enum  WeshopVisitUidTypeEnum {
    UN_KNOW(0, "未知"),
    USER_ID(1, "用户id"),
    IP(2, "访问ip"),
    ;

    private Integer key;

    private String value;

    private WeshopVisitUidTypeEnum(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    private WeshopVisitUidTypeEnum(Integer key){
        this.key = key;
    }

    public static WeshopVisitUidTypeEnum getEnumByKey(Integer key) {
        for(WeshopVisitUidTypeEnum x: WeshopVisitUidTypeEnum.values()) {
            if(x.getKey().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public static WeshopVisitUidTypeEnum getEnumByValue(String value) {
        for(WeshopVisitUidTypeEnum x: WeshopVisitUidTypeEnum.values()) {
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
