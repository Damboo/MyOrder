package com.joy.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    String name() default "";

    String type() default "";

    int length() default 0;

    int scale() default 0;

    boolean notNull() default false;

    boolean autoIncrement() default false;

    String defaultValue() default "NULL";

    String comment() default "";
}
