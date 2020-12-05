package com.syr.No1_Thread.thread3;

/**
 * 测试线程状态
 * @author syr
 */
public class ThreadState {

    public static void main(String[] args) throws InterruptedException {
        //lambda表达式
        Thread thread = new Thread( ()-> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("//////////");
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state);//NEW

        //观察启动后线程
        thread.start();
        state = thread.getState();
        System.out.println(state);//RUN

        while(state != Thread.State.TERMINATED){//只要线程不终止，就一直输出状态
            Thread.sleep(100);
            //更新状态
            state = thread.getState();
            System.out.println(state);
        }

    }

}
