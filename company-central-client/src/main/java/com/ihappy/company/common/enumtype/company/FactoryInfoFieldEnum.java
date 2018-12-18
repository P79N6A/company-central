package com.ihappy.company.common.enumtype.company;

/**
 * Created by renyueliang on 2018/8/9.
 */
public enum FactoryInfoFieldEnum {

    CUTBED_BUMBER("cutbedNumber","裁床数") ,
    BACK_NUMBER("backendNumber","后道数") ,
    WORKSHOP_NUMBER("workshopNumber","车间数") ,
    ONTHEWAY_NUMBER("onthewayNumber","待入库数") ,
    ;

    private String fieldName;
    private String fieldCode;

    public String getFieldName() {
        return fieldName;
    }


    public String getFieldCode() {
        return fieldCode;
    }


    FactoryInfoFieldEnum(String fieldCode, String fieldName) {
        this.fieldName = fieldName;
        this.fieldCode = fieldCode;
    }



}
