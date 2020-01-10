package com.yarm.service;

import java.lang.annotation.*;

/**
 * @program: base-parent
 * @description: 关闭job
 * @author: yarm.yang
 * @create: 2020-01-10 16:50
 */
//@Target(ElementType.METHOD)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StopJob {
    String value() default "";
}
