package com.syr.No1_thread.thread1;

/**
 * 问题一：龟兔赛跑问题
 * 实现Runnable接口
 * =========================
 * @author syr
 * TODO: 2020/11/18
 */
public class TestThread2_test1  implements Runnable{

    //获胜者
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <=100; i++) {

            //让兔子睡觉
            if(Thread.currentThread().getName().equals("兔子") && i%10==5){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //判断比赛是否结束
            boolean flag = gameOver(i);

            //已经有胜利者，结束程序
            if(flag){
                break;
            }

            System.out.println(Thread.currentThread().getName()+"——>跑了"+i+"步");
        }
    }

    //判断是否完成比赛
    private boolean gameOver(int steps){

        //已经存在胜利者
        if(winner!=null){
            return true;
        }
        else if(steps>=100){
            //胜利者是谁？
            winner = Thread.currentThread().getName();
            System.out.println("Winner is "+winner);
            return  true;
        }
        return false;
    }

    public static void main(String[] args) {
        //创建Runnable子类对象
        TestThread2_test1 t = new TestThread2_test1();

        //new Thread(对象)，调用start启动线程
        new Thread(t,"乌龟").start();
        new Thread(t,"兔子").start();
    }
}
