package com.syr.No2_annotation;

import javafx.scene.control.Tab;

import javax.xml.bind.Element;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * 反射操作注解
 * @author syr
 * // TODO: 2020/12/1
 */
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.syr.No2_annotation.Student2");

        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //获得注解value的值
        Table table= (Table)c1.getAnnotation(Table.class);
        System.out.println(table.value());

        //获得类指定的注解
        Field name = c1.getDeclaredField("name");
        colum annotation = name.getAnnotation(colum.class);
        System.out.println(annotation.name());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}

@Table("db_student")
class Student2{

    @colum(name = "id",type = "int",length = 10)
    private int id;

    @colum(name = "age",type = "int",length = 20)
    private int age;

    @colum(name = "name",type = "String",length = 20)
    private String name;

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface colum{
    String name();
    String type();
    int length();
}