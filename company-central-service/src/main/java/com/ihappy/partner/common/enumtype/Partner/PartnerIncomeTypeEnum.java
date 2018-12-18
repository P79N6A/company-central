package com.ihappy.partner.common.enumtype.Partner;

/**
 * Created by sunjd on 2018/4/19.
 */
public enum PartnerIncomeTypeEnum {
    EXPENDITURE(1,"支出"),
    INCOME(2,"收入");

    private Integer key;

    private String value;

    private PartnerIncomeTypeEnum(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    private PartnerIncomeTypeEnum(Integer key){
        this.key = key;
    }

    public static PartnerIncomeTypeEnum getEnum(Integer key) {
        for(PartnerIncomeTypeEnum x: PartnerIncomeTypeEnum.values()) {
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
