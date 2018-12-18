package com.ihappy.partner.common.enumtype.partner;

/**
 * Created by sunjd on 2018/5/3.
 */
public enum PartnerLevelEnum {
    SUBTRACT(-1,-1),
    ADD(1,1);

    private Integer key;

    private Integer value;

    private PartnerLevelEnum(Integer key, Integer value){
        this.key = key;
        this.value = value;
    }

    private PartnerLevelEnum(Integer key){
        this.key = key;
    }

    public static PartnerLevelEnum getEnum(Integer key) {
        if (key == null){
            return null;
        }
        for(PartnerLevelEnum x: PartnerLevelEnum.values()) {
            if(x.getKey().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public Integer getKey(){
        return this.key;
    }

    public Integer getValue(){
        return this.value;
    }
}
