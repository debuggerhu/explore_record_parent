package com.hhx.common.config.annotetion;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 该注解使用restful风格接口代替
 */
@Deprecated
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParseBaseTypeJson {
    /**
     * 是否必须出现的参数
     */
    boolean required() default true;

    /**
     * 定义jsonKey
     */
    String value() default "";
}

