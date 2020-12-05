package com.syr.No1_Thread.thread4;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author syr
 * // TODO: 2020/11/27
 * 锁的实现
*/
public class Lock {
    public static void main(String[] args) {
        Buy_ticket buyticket = new Buy_ticket();

        new Thread(buyticket).start();
        new Thread(buyticket).start();
        new Thread(buyticket).start();

    }

}

class Buy_ticket implements Runnable{
    int ticketnum = 10;

    //定义锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            try{
                lock.lock();//加锁
                if(ticketnum<=0){
                    return;
                }
                try {
                    //方法问题发生的概率
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(ticketnum--);
            }finally {
                lock.unlock();//释放锁
            }
        }
    }
}