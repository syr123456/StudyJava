package com.syr.No2_Annotation;

/**
 * 类的加载器
 * @author syr
 * // TODO: 2020/12/1
 */
public class Test05 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.获取系统类加载器
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        //2.系统类加载器父类-扩展类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        //3.扩展类加载器父类->引导类加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类是那个类加载器
        ClassLoader classLoader1 = Class.forName("com.syr.No2_Annotation.Test05").getClassLoader();
        System.out.println(classLoader1);

        //测试JDK内的类是谁加载的
        classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);

        //获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
    }
}
