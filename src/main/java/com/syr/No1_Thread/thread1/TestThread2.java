package com.syr.No1_Thread.thread1;

/**
 * 创建线程方式二：实现Runnable
 * 1.实现Runnable类，重写run方法
 * 2.创建实现类的对象，new Thread（对象）
 * 3.调用start开启线程
 * =================================
 * @author syr
 * TODO: 2020/11/18
 */
public class TestThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            //run方法
            System.out.println("run方法"+i);
        }
    }

    public static void main(String[] args) {
        //main方法，主线程
        //创建对象，new Thread
        TestThread2 testThread2 = new TestThread2();
        new Thread(testThread2).start();

        for (int i = 0; i < 500; i++) {
            System.out.println("main方法"+i);
        }
    }
}
