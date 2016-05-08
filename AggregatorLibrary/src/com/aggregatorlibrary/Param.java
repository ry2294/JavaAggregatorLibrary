package com.aggregatorlibrary;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Creating a new @Param annotation, which the users can use to pass parameters around dependent classes.
 * This can be used by the users when they are modifying the same object in different tasks or 
 * they need to pass data between tasks.
 */ 
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Param {

}
