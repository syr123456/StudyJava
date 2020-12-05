package com.syr.No1_Thread.thread4;

/**
 * 三大不全的案例：1.不安全的买票+2.不安全的取钱+3.不安全的集合ArrayList
 * @author syr
 * TODO: 2020/11/27
 * 1.不安全的买票->在buy方法加入synchronized。变为安全的买票
 * 注：每个线程都在自己的工作内存交互，内存控制不当会导致数据不一致
 */
public class UnsafeBuyticket {

    public static void main(String[] args) {
        Buyticket buyticket = new Buyticket();

        new Thread(buyticket,"小明").start();
        new Thread(buyticket,"黄牛党").start();

    }

}

class Buyticket implements Runnable{

    int ticketnum = 10;//票的总数
    boolean flag = true;//线程停止方式（利用标志位停止）

    @Override
    public void run() {
        //买票
        while(flag){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            buy();
        }
    }

    //模拟买票
    //synchronized同步方法，锁的是this
    private synchronized void buy(){
        //判断是否有票
        if(ticketnum<=0){
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName()+"拿到了"+ticketnum--);

    }

}
