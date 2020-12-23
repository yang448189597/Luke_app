package com.example.luke_app;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/*
 * @Author: Luke
 * @Date: 12/23/20 6:03 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */

@Retention(RUNTIME) @Target(TYPE)
public @interface ViewInject {
//    @Retention(RUNTIME)  运行时注解
//    @Target(TYPE) 作用域的注解
    int mainLayoutid() default -1;
}
