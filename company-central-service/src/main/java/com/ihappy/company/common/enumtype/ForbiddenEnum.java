package com.ihappy.company.common.enumtype;

/**
 * Created by sunjd on 2018/5/15.
 */
public enum ForbiddenEnum {
    ENABLE(0,"启用"),
    DISABLE(1,"禁用"),
    ;

    private Integer key;

    private String value;

    private ForbiddenEnum(Integer key, String value){
        this.key = key;
        this.value = value;
    }

    private ForbiddenEnum(Integer key){
        this.key = key;
    }

    public static ForbiddenEnum getEnum(Integer key) {
        for(ForbiddenEnum x: ForbiddenEnum.values()) {
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
