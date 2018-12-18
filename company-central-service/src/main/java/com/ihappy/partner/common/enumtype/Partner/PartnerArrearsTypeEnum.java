package com.ihappy.partner.common.enumtype.Partner;

/**
 * Created by sunjd on 2018/4/18.
 */
public enum PartnerArrearsTypeEnum {
    INOCME(2,-1),
    EXPENDITURE(1,1);

    private Integer key;

    private Integer value;

    private PartnerArrearsTypeEnum(Integer key, Integer value){
        this.key = key;
        this.value = value;
    }

    private PartnerArrearsTypeEnum(Integer key){
        this.key = key;
    }

    public static PartnerArrearsTypeEnum getEnum(Integer key) {
        for(PartnerArrearsTypeEnum x: PartnerArrearsTypeEnum.values()) {
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
