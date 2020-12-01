package com.syr.No2_annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 动态创建对象，利用反射
 * @author syr
 * // TODO: 2020/12/1
 */
public class Test07 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("com.syr.No2_annotation.User");

        //构造一个对象
        User user = (User) c1.newInstance();
        System.out.println(user.getName());

        //通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, String.class);
        User user1 = (User) constructor.newInstance("Songyaru","001");
        System.out.println(user1.getName());

        //通过反射调用普通方法
        User user2 = (User) c1.newInstance();
        //通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user2,"宋亚茹");//invoke:激活（对象，对象的值）
        System.out.println(user2.getName());

        //获取属性
        Field id = c1.getDeclaredField("id");
        //不能直接操作私有属性，需要关闭程序的安全检测，setAccessible方法
        id.setAccessible(true);//关闭权限检测
        id.set(user2,"002");
        System.out.println(user2.getId());

    }
}
