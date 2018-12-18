package com.ihappy.store.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by sunjd on 2018/8/13.
 * 接口迁移注解
 */
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Transfer {
    public String value() default "迁移接口完整类路径";
    public String memo() default "接口迁移注解:value为迁移接口,方法不变";
}
