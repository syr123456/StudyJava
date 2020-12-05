package com.syr.No1_Thread.thread5;

/**
 * 信号灯法
 * @author syr
 * // TODO: 2020/11/27
 * 生产者消费者问题：利用信号灯发解决（利用标志位）
 * 演员，观众，节目
 */
public class TestPC2 {

    public static void main(String[] args) {
        TV tv = new TV();

        new Actor(tv).start();
        new Watcher(tv).start();
    }

}

//生产者->演员
class Actor extends Thread{
    TV tv;
    public Actor(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2==0){
                try {
                    this.tv.play("快乐大本营");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    this.tv.play("广告");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

//消费者->观众
class Watcher extends Thread{
    TV tv;
    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                tv.watch();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//产品->节目
class TV{
    //演员表演，观众等待 T
    //观众观看，演员等待 F
    String voice;//表演的节目
    boolean flag  = true;//默认为true


    //表演
    public synchronized void play(String voice) throws InterruptedException {
        if(!flag){//观众观看，演员等待
            this.wait();
        }
        System.out.println("演员表演了"+voice);
        //通知观众等待
        this.notifyAll();
        this.voice = voice;
        this.flag = !flag;
    }

    //观看
    public synchronized void watch() throws InterruptedException {
        if(flag){//演员表演，观众等待
            this.wait();
        }
        System.out.println("观众观看了"+voice);
        //通知演员表演
        this.notifyAll();
        this.flag= !flag;
    }

}