package com.example.wx_1025.my_annotation;


import java.lang.annotation.*;


/**
 * The interface Redis annotation.用于redis切面的注解
 * @author chenj
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface redisAnnotation {

}
