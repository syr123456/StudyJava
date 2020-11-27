package com.syr.No1_thread.thread1;


/**
 * 问题二：抢票问题
 * 实现Runnable接口
 * 多个线程操作同一个对象
 *
 * 注意：多个对象操作同一资源，线程不安全，数据紊乱
 * 老师和黄牛会同时抢到同一张票
 * =======================
 * @author syr
 * TODO: 2020/11/18
 */
public class TestThread2_test2 implements Runnable{

    private int ticketNum = 10;

    @Override
    public void run() {
        while(true){
            if(ticketNum<=0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"——>抢到第"+ticketNum+"票");
            ticketNum--;
        }
    }


    public static void main(String[] args) {
        //创建Runnable子类对象
        TestThread2_test2 t = new TestThread2_test2();

        //new Thread(对象)，调用start启动线程
        new Thread(t,"黄牛").start();
        new Thread(t,"老师").start();
    }
}
