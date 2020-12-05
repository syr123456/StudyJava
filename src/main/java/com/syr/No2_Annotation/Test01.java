package com.syr.No2_Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 测试注解+自定义注解
 * @author syr
 * // TODO: 2020/11/30
 */
@Annotation(age = 18)
public class Test01 {

    //注解可以显式赋值，如果没有默认值，需要给注解赋值
    @Annotation(age = 18)
    public static void main(String[] args) {

    }

    //注解中参数是value，可以省略value，直接赋值
    @Annotation1(value = "song")
    public void test(){

    }
}


//定义一个注解
//Target 表示注解用在什么位置->此处指用在方法上和类上
//Retention 表示注解在什么时候有效
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation{
    //注解的参数：参数类型，参数名()
    String name() default "";
    int age();
    //如果默认值为-1表示不存在；indexof如果找不到返回-1
    int id() default  -1;
    String[] school() default {"西部开源","清华大学"};

}


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation1{
    String value();
}