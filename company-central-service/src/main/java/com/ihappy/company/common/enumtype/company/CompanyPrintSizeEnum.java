package com.ihappy.company.common.enumtype.company;

/**
 * Created by sunjd on 2018/5/25.
 */
public enum CompanyPrintSizeEnum {
    ENTERPRISE("80MM","MM_80"),
    SELF_EMPLOY("110MM","MM_110"),
    STYLUS_PRINTER("针式打印机","MM_9999");
    private String key;

    private String value;

    private CompanyPrintSizeEnum(String key, String value){
        this.key = key;
        this.value = value;
    }

    private CompanyPrintSizeEnum(String key){
        this.key = key;
    }

    public static CompanyPrintSizeEnum getEnumByKey(String key) {
        for(CompanyPrintSizeEnum x: CompanyPrintSizeEnum.values()) {
            if(x.getKey().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public static CompanyPrintSizeEnum getEnumByValue(String value) {
        for(CompanyPrintSizeEnum x: CompanyPrintSizeEnum.values()) {
            if(x.getValue().equals(value)) {
                return x;
            }
        }
        return null;
    }

    public String getKey(){
        return this.key;
    }

    public String getValue(){
        return this.value;
    }
}
