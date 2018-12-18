package com.ihappy.partner.common.enumtype.partner;

/**
 * Created by sunjd on 2018/8/9.
 * Partner 欠款/预存款 操作类型
 */
public enum PartnerArrearsOperateTypeEnum {
    RESERVED(0,"保留值"),
    ARREARS(1, "欠款"),
    PREPAID_DEPOSIT(2, "预存款"),
    ;

    private Integer key;

    private String value;

    private PartnerArrearsOperateTypeEnum(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    private PartnerArrearsOperateTypeEnum(Integer key){
        this.key = key;
    }

    public static PartnerArrearsOperateTypeEnum getEnumByKey(Integer key) {
        for(PartnerArrearsOperateTypeEnum x: PartnerArrearsOperateTypeEnum.values()) {
            if(x.getKey().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public static PartnerArrearsOperateTypeEnum getEnumByValue(String value) {
        for(PartnerArrearsOperateTypeEnum x: PartnerArrearsOperateTypeEnum.values()) {
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
