package com.syr.No2_Annotation;

/**
 * 测试类的主动引用和被动引用
 * @author syr
 * // TODO: 2020/12/1
 */
public class Test04 {
    static {
        System.out.println("main被加载");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        //1.主动引用，会产生类的初始化
//        Son son = new Son();

        //2.主动引用，会产生类的初始化
//        Class.forName("com.syr.No2_annotation.Son");

        //3.被动引用,不会产生类的初始化
//        System.out.println(Son.b);

        //4.不会产生类的初始化，只是创建一块空间
//        Son[] sons= new Son[5];

        //5.常量,在类的链接就已经加载到了常量池中
        System.out.println(Son.M);
    }
}

class Father{
    static  int b = 1;
    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    static{
        System.out.println("子类被加载");
        int m = 200;
    }
    static  int m = 100;
    static  final int M = 10;
}