package com.syr.No2_annotation;

/**
 * 1.反射测试
 * 2.获取Class类的方法
 * @author syr
 * // TODO: 2020/11/30
 */
public class Test02 {

    public static void main(String[] args) throws ClassNotFoundException {
        /*1.通过反射获取类的Class对象*/
        Class c1 = Class.forName("com.syr.No2_annotation.User");
        System.out.println(c1);
        Class c2 = Class.forName("com.syr.No2_annotation.User");
        /*2.可以发现c1.hashCode()  = c2.hashCode()；所以：一个类在内存中只有一个Class对象*/
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        /*3.注意：
        （1）一个类被加载后，类的整个结构都会被封装在class对象中
        （2）Class本身也是一个类其对象只能由系统建立
        （3）一个记载的类在JVM中只会有一个Class实例*/

        User user = new Student();
        System.out.println("这个人是:"+user.name);
        /*方式一：通过对象获得*/
        Class c3 = user.getClass();
        System.out.println(c3);
        /*方式二：通过，foname获得*/
        Class c4 = Class.forName("com.syr.No2_annotation.Student");
        System.out.println(c4);
        /*方式三：通过类名。class获得*/
        Class c5 = Student.class;
        System.out.println(c5);
        /*方式四：基本内置类型的包装类都有一个TYPE*/
        Class c6 = Integer.TYPE;
        System.out.println(c6);
        /*获得父类的类型*/
        Class c7 = c3.getSuperclass();
        System.out.println(c7);

    }
}

//实体类
class User{
    public String name;
    private String id;


    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}

//学生
class Student extends User{
    public Student() {
        this.name= "学生";
    }
}

//老师
class Teacher extends User{
    public Teacher() {
        this.name = "老师";
    }
}