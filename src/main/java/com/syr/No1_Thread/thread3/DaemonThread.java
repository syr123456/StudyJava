package com.syr.No1_Thread.thread3;

/**
 * @author syr
 * TODO: 2020/11/26
 * 守护线程：虚拟机确保用户线程执行完毕，不用管守护线程
 * GC是守护线程
 */
public class DaemonThread {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true);//上帝是守护线程

        thread.start();//上帝启动

        new Thread(you).start();//你启动
    }
}

class God implements Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println("上帝保护着你！");
        }
    }
}

class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生开心的活着");
        }
        System.out.println("==========goodbey!world!===========");
    }
}
