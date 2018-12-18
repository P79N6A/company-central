package com.ihappy.company.common.enumtype;

import com.ihappy.company.common.enumtype.company.CompanyPrintSizeEnum;

/**
 * Created by sunjd on 2018/6/5.
 * 基础操作枚举类-增删改查
 */
public enum BaseOperateEnum {
    ADD("add","添加"),
    DELETE("delete","删除"),
    UPDATE("update","修改"),
    SELECT("select","查询"),
    OTHER("other","其他");

    private String key;

    private String value;

    private BaseOperateEnum(String key, String value){
        this.key = key;
        this.value = value;
    }

    private BaseOperateEnum(String key){
        this.key = key;
    }

    public static BaseOperateEnum getEnumByKey(String key) {
        for(BaseOperateEnum x: BaseOperateEnum.values()) {
            if(x.getKey().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public static BaseOperateEnum getEnumByValue(String value) {
        for(BaseOperateEnum x: BaseOperateEnum.values()) {
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
