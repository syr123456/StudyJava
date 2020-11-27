package com.syr.No1_thread.thread2;

/**
 * @author syr
 * TODO: 2020/11/21
 * Lambda表达式->进阶过程
 * 注意：避免内部类定义过多
 *
 * 函数式接口：1.任何接口只包含（唯一一个抽象方法），即函数式接口
 *           2.可以利用Lambda表达式创建函数式接口的对象
 *
 * result:
 * I like lambda1
 * I like lambda2
 * I like lambda3
 * I like lambda4
 * I like lambda5
 */
public class Lambda {

    //2.静态内部类
    static class Like2 implements Ilike{

        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }

    public static void main(String[] args) {
        //创建实现接口的对象
        //1.外部类
        Ilike ilike = new Like1();
        ilike.lambda();

        //2.静态内部类
        ilike = new Like2();
        ilike.lambda();

        //3.局部内部类
        class Like3 implements Ilike{
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }
        ilike = new Like3();
        ilike.lambda();

        //4.匿名内部类
        ilike = new Ilike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        ilike.lambda();

        //5.Lambda表达式
        ilike = ()->{
            System.out.println("I like lambda5");
        };
        ilike.lambda();

    }

}

//函数式接口
interface Ilike{
    void lambda();
}

//1.外部类->实现类
class Like1 implements Ilike{

    @Override
    public void lambda() {
        System.out.println("I like lambda1");
    }
}
