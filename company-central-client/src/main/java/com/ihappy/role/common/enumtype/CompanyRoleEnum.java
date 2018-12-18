package com.ihappy.role.common.enumtype;

/**
 * Created by sunjd on 2018/6/22.
 */
public enum CompanyRoleEnum {
    BOSS(0,"老板"),
    PARTNER(1,"合伙人"),
    SHOP_MANAGER(2,"店长"),
    STAFF(3, "店员"),
    FACTORY_MANAGER(4, "工厂管理员"),
    GOODS_MANAGER(5, "商品管理员"),
    FACE_EXCIPIENT(13, "面辅料管理员"),
    ;

    private Integer key;
    private String value;

    private CompanyRoleEnum(Integer key, String value){
        this.key = key;
        this.value = value;
    }
    public static CompanyRoleEnum getEnumByKey(Integer key) {
        for(CompanyRoleEnum x: CompanyRoleEnum.values()) {
            if(x.getKey().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public static CompanyRoleEnum getEnumByValue(String value) {
        for(CompanyRoleEnum x: CompanyRoleEnum.values()) {
            if(x.getValue().equals(value)) {
                return x;
            }
        }
        return null;
    }
    public Integer getKey() {
        return key;
    }

    public String getValue(){
        return this.value;
    }

    public boolean isBOSSorPARTNER(){
        return this == BOSS || this == PARTNER;
    }

    public static boolean isPartner(int key) {
        return key == PARTNER.getKey();
    }


}
