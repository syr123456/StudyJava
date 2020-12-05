package com.syr.No1_Thread.thread3;

/**
 * 插队：join
 * @author syr
 * TODO: 2020/11/26
 * Join合并线程，待此线程完成后，在执行其他线程，其他线程阻塞
 */
public class JoinThread  implements  Runnable{

    public static void main(String[] args) throws InterruptedException {
        JoinThread joinThread = new JoinThread();
        Thread thread = new Thread(joinThread);
        thread.start();

        for (int i = 0; i < 100; i++) {
            if(i==50){
                //若为new Thread().start()，main和join两个都会同时穿插进行
                //thread,待join线程完成后在开启main线程
                thread.join();//main线程阻塞，join线程插队开启
            }
            System.out.println("main线程……"+i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("线程vip来了……"+i);
        }
    }
}
