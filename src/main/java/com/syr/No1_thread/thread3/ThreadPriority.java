package com.syr.No1_thread.thread3;

/**
 * 线程优先级
 * @author syr
 * TODO: 2020/11/26
 * 优先级高的线程不一定先执行，要看CPU的心情
 */
public class ThreadPriority {

    public static void main(String[] args) {
        //主线程默认优先级 5
        System.out.println(Thread.currentThread().getName()+"->"+Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();

        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);
        Thread t6 = new Thread(myPriority);

        //先设置优先级在启动
        t1.start();

        t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();

        t3.setPriority(Thread.NORM_PRIORITY);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();

//        t5.setPriority(-1);
//        t5.start();
//
//        t6.setPriority(11);
//        t6.start();
    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"->"+Thread.currentThread().getPriority());
    }
}