package com.ihappy.communal.infrastructure.util;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.enumtype.DefaultValueEnum;
import com.ihappy.company.exception.CompanyException;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 将值为null的字段填充默认值
 * Created by sunjd on 2018/4/8.
 */
public class FillDefaultValue {
    public static void fillDefault(Object obj) {
        try{
            Class objClass= obj.getClass();
            Field ff[]= objClass.getDeclaredFields();
            for(int i=0;i<ff.length;i++){
                Field f=ff[i];//取出每一个属性，如deleteDate
                f.setAccessible(true);
                //包含final 和 static关键字的属性跳过
                String modifier = Modifier.toString(f.getModifiers());
                if(modifier.contains("final") || modifier.contains("static")) continue;
                if(f.get(obj) == null){
                    String type = f.getGenericType().toString();
                    if (DefaultValueEnum.getEnum(type).getValue() != null)
                    f.set(obj, DefaultValueEnum.getEnum(type).getValue());
                };
            }
        }catch (Exception e){
            throw new CompanyException(CompanyErrorCodeEnum.
                    FILL_DEFAULT_VALUE_ERROR.getErrCode(),
                    CompanyErrorCodeEnum.FILL_DEFAULT_VALUE_ERROR.getErrMsg());
        }
    }
}
