package com.lq.code.annotation;

import java.lang.annotation.*;

/**
 * Created by qi_liang on 2018/4/26.
 * @author qi
 */
@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {
    int value() default 50;

}
