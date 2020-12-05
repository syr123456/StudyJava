package com.syr.No1_Thread.thread4;

/**
 * deadlock:多个线程互相抱着对方需要的资源，然后形成僵持
 * 死锁：当将两个synchronized块套叠在一起会出现死锁的情况：因为不释放该锁，还想获得别人手中持有的锁。
 * 解决方法：将synchonized块并排在一起即可解决。先释放手中的锁，再去获得别人释放的锁。
 * @author syr
 * // TODO: 2020/11/27
 *
 */
public class DeadLock {
    public static void main(String[] args) {
        Makeup makeup1 = new Makeup(0,"红红");
        Makeup makeup2 = new Makeup(1,"花花");

        makeup1.start();
        makeup2.start();

    }
}
//口红
class Lipstick{
}
//镜子
class Mirror{
}
//化妆
class Makeup extends Thread{
    //需要的资源只有一份，用statis保证只有一份
    private static Lipstick lipstick = new Lipstick();
    private static Mirror mirror = new Mirror();

    int choice;//选择
    String name;//使用者

    Makeup(int choice,String name){
        this.choice = choice;
        this.name = name;
    }


    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆，互相持有对方的锁，需要拿到对象的资源
    private void makeup() throws InterruptedException {
        if(choice == 0){
            synchronized (lipstick){//获得口红的锁
                System.out.println(this.name+"获得口红的锁");
                Thread.sleep(1000);
                synchronized (mirror){//一秒钟后想获得镜子的锁
                    System.out.println(this.name+"获得镜子的锁");
                }
            }
        }
        else {
            synchronized (mirror) {//获得镜子的锁
                System.out.println(this.name + "获得镜子的锁");
                Thread.sleep(1000);
                synchronized (lipstick) {
                    System.out.println(this.name+"获得口红的锁");
                }
            }
        }
    }
}
