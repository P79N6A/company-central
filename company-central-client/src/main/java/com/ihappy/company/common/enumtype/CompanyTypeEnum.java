package com.ihappy.company.common.enumtype;

/**
 * @author : zhangtengpo
 * @Description :  公司业务类型枚举类
 * @create : 2018-05-30 13:54
 */
public enum CompanyTypeEnum {
    FIRSST_LEVEL_WHOLESALER(1, "一级批发商"),
    SECOND_LEVEL_WHOLESALER(2, "二级批发商"),
    RETAILERS(3, "零售商")
    ;

    private Integer typeCode;
    private String typeName;

    private CompanyTypeEnum(Integer typeCode, String typeName){
        this.typeCode = typeCode;
        this.typeName = typeName;
    }
    public static CompanyTypeEnum getEnumByKey(Integer key) {
        for(CompanyTypeEnum x: CompanyTypeEnum.values()) {
            if(x.getTypeCode().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public static CompanyTypeEnum getEnumByValue(String value) {
        for(CompanyTypeEnum x: CompanyTypeEnum.values()) {
            if(x.getTypeName().equals(value)) {
                return x;
            }
        }
        return null;
    }

    public String getTypeName(){
        return this.typeName;
    }

    public Integer getTypeCode() {
        return typeCode;
    }
}
