package com.syr.No1_Thread.thread1;

/**
 * 创建线程方式一：继承Thread方法
 * 1.继承Thread类，重写run（）方法
 * 2.创建子类的对象
 * 3.调用start开启线程
 * ============================
 * 用户线程：main主线程
 * 守护线程：Gc垃圾回收线程
 * @author syr
 * TODO: 2020/11/18
 */
public class TestThread1 extends Thread{

    @Override
    public void run() {
        //run方法
        for (int i = 0; i < 20; i++) {
            System.out.println("run方法"+i);
        }
    }

    public static void main(String[] args) {
        //主方法，main线程
        //创建对象，启动线程
        TestThread1 t1 =new TestThread1();
        t1.start();
        //main函数中的方法与run方法交替执行
        for (int i = 0; i < 200; i++) {
            System.out.println("main方法"+i);
        }
    }
}
