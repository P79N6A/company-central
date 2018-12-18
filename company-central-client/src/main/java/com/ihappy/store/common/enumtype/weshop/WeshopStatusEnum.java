package com.ihappy.store.common.enumtype.weshop;

/**
 * Created by sunjd on 2018/7/4.
 * 微商铺状态枚举类
 */
public enum WeshopStatusEnum {
    DRAFT(0, "草稿"),
    ONLINE(1, "发布"),
    OFFLINE(2, "下线"),
    ;

    private Integer key;

    private String value;

    private WeshopStatusEnum(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    private WeshopStatusEnum(Integer key){
        this.key = key;
    }

    public static WeshopStatusEnum getEnumByKey(Integer key) {
        for(WeshopStatusEnum x: WeshopStatusEnum.values()) {
            if(x.getKey().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public static WeshopStatusEnum getEnumByValue(String value) {
        for(WeshopStatusEnum x: WeshopStatusEnum.values()) {
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
