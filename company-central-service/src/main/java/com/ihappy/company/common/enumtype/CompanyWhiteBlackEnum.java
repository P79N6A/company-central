package com.ihappy.company.common.enumtype;

/**
 * @author gongwenqiang
 * @version V1.0.0
 * @date 2018/11/7 2:46 PM
 */
public enum   CompanyWhiteBlackEnum {
    BLACK(0,"黑名单"),

    NORMAL(1,"普通"),

    WHITE(2,"白名单");

    private Integer key;

    private String value;

    private CompanyWhiteBlackEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    private CompanyWhiteBlackEnum(Integer key) {
        this.key = key;
    }

    public static CompanyWhiteBlackEnum getCompanyStatusEnum(Integer key) {
        for (CompanyWhiteBlackEnum x : CompanyWhiteBlackEnum.values()) {
            if (x.getKey().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public Integer getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}
