package com.sbt.serialization;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Cache {
    CacheType type() default CacheType.IN_MEMORY;
    boolean zip() default false;
}
