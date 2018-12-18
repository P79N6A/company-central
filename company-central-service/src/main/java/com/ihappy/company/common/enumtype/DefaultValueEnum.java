package com.ihappy.company.common.enumtype;

/**
 * Created by sunjd on 2018/4/8.
 */
public enum DefaultValueEnum {
    Long("class java.lang.Long",0L),
    String("class java.lang.String",""),
    Integer("class java.lang.Integer",0),
    Double("class java.lang.Double",0D),
    Boolean("class java.lang.Boolean",false),
    Byte("class java.lang.Byte",(byte)0),
    Float("class java.lang.Float",0F);

    private String key;

    private Object value;

    private DefaultValueEnum(String key, Object value){
        this.key = key;
        this.value = value;
    }

    private DefaultValueEnum(String key){
        this.key = key;
    }

    public static DefaultValueEnum getEnum(String key) {
        for(DefaultValueEnum x: DefaultValueEnum.values()) {
            if(x.getKey().equals(key)) {
                return x;
            }
        }
        return null;
    }

    public String getKey(){
        return this.key;
    }

    public Object getValue(){
        return this.value;
    }
}
