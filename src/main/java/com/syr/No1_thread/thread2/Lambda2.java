package com.syr.No1_thread.thread2;

/**
 * @author syr
 * TODO: 2020/11/21
 * lambda表达式练习2:带参数
 *
 * result:
 * I love you521
 * I love you520
 * I love you519
 * I love you518
 * I love you517
 */
public class Lambda2 {

    //静态内部类
    static class love2 implements Ilove {

        @Override
        public void love(int a) {
            System.out.println("I love you" + a);
        }
    }

    public static void main(String[] args) {
        //1.外部类
        Ilove ilove = new love1();
        ilove.love(521);

        //2.内部类
        ilove = new love2();
        ilove.love(520);

        //3.局部内部类
        class love3 implements Ilove {
            @Override
            public void love(int a) {
                System.out.println("I love you" + a);
            }
        }
        ilove = new love3();
        ilove.love(519);

        //4.匿名内部类
        ilove = new Ilove() {
            @Override
            public void love(int a) {
                System.out.println("I love you"+a);
            }
        };
        ilove.love(518);

        //5.Lambda表达式
        //总结：lambda表达式只能有一行代码的情况下才能简化成一行
              //如果有多行，那代码块包裹
              //前提是函数式接口
              //多个参数可以是（a,b,c,……）,方法只有一个
        ilove = a-> System.out.println("I love you"+a);
        ilove.love(517);
//        ilove = (a,b)->{
//            System.out.println("I love you"+a);
//            System.out.println("I love you"+b);
//        };


    }

}

interface Ilove{
    void love(int a);
}

class love1 implements Ilove{

    @Override
    public void love(int a) {
        System.out.println("I love you"+a);
    }
}