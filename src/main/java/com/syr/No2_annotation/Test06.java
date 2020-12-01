package com.syr.No2_annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 获得类的属性
 * @author syr
 * // TODO: 2020/12/1
 */
public class Test06 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.syr.No2_annotation.User");

        User user = new User();
        c1 = user.getClass();

        //获得类的名字
        System.out.println(c1.getName());//获得包名+类名
        System.out.println(c1.getSimpleName());//获得类名

        //获得类的属性
        System.out.println("getFields============");
        Field[] fields = c1.getFields();//获得public属性
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("getDeclaredFields()============");
        fields = c1.getDeclaredFields();//获得所有属性
        for (Field field : fields) {
            System.out.println(field);
        }

        //获得指定属性
        System.out.println("getDeclaredField指定名字============");
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        //获得类的方法
        System.out.println("getMethods============");//获得本类及父类收中所有public方法
        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("getDeclaredMethods============");//获得本类中的所有方法
        methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

    }
}
