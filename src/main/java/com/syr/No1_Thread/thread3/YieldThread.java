package com.syr.No1_Thread.thread3;

/**
 * 礼让线程，让当前正在执行的线程暂停，但不阻塞
 * @author syr
 * TODO:2020/11/26
 * yield礼让不一定成功，看CPU心情
 * 礼让将线程从运行状态转为就绪状态
 */
public class YieldThread {

    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield,"A").start();
        new Thread(myYield,"B").start();

    }

}

class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始运行");
        Thread.yield();//线程礼让
        System.out.println(Thread.currentThread().getName() + "线程停止运行");
    }
}
