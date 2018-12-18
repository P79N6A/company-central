package com.ihappy.company.common.enumtype.company;

/**
 * Created by chenying on 2018/11/19.
 */
public enum  CompanyBarCodePrintSizeEnum {
    ENTERPRISE("80mm","MM_80"),
    SELF_EMPLOY("110mm","MM_110"),
    ENTERPRISE_UP("80MM","MM_80"),
    SELF_EMPLOY_UP("110MM","MM_110"),
    STYLUS_PRINTER("针式打印机","MM_9999"),
    BAR_58MM_40MM("58mm*40mm","58mm*40mm"),
    BAR_58MM_30MM("58mm*30mm","58mm*30mm");
    private String key;

    private String value;

    private CompanyBarCodePrintSizeEnum(String key, String value){
        this.key = key;
        this.value = value;
    }

    private CompanyBarCodePrintSizeEnum(String key){
        this.key = key;
    }

    public static CompanyBarCodePrintSizeEnum getEnumByKey(String key) {
        for(CompanyBarCodePrintSizeEnum x: CompanyBarCodePrintSizeEnum.values()) {
            if(x.getKey().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public static CompanyBarCodePrintSizeEnum getEnumByValue(String value) {
        for(CompanyBarCodePrintSizeEnum x: CompanyBarCodePrintSizeEnum.values()) {
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
