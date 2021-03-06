package com.wangyz.mydemo.souce;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExceptionCode {
    int value() default 100000;
    String message() default "参数校验失败";
}
