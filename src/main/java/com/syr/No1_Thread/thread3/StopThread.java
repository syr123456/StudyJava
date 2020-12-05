package com.syr.No1_Thread.thread3;

/**
 * 测试线程停止：
 * 1.建议线程正常停止，利用次数，不建议死循环（使用延迟）
 * 2.建议使用标志位，（使用标志位停止flag线程，当flag=flase时停止线程）
 * 不推荐使用JDK提供的stop方法，destroy方法
 * @author syr
 * TODO: 2020/11/24
 */
public class StopThread implements Runnable{

    //1.设置一个标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while(flag){
            System.out.println("run…………Thread"+i++);//先使用后赋值
        }
    }

    //2.设置一个公开的方法停止线程，改变标志置位
    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        StopThread stopThread = new StopThread();

        new Thread(stopThread).start();

        for (int i = 0; i < 600; i++) {
            System.out.println("main……"+i);
            if(i==500){
                //调用stop方法，切换标志位，停止线程
                stopThread.stop();
                System.out.println("线程该停止了！");
            }
        }

    }
}
