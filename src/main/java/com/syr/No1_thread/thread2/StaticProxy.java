package com.syr.No1_thread.thread2;

/**
 * @author syr
 * TODO: 2020/11/21
 * 静态代理：婚庆公司Company代理You + Thread代理Runnable接口
 * 总结：
 * 1.真是对象You和代理对象Company---->>>都要实现同一个接口Marry
 * 2.代理对象Company要代理真实角色You
 * 好处：
 * 1.Company可以代理You做很多（You做不了）的事情
 * 2.You专注做自己的事情
 *
 * result:
 * 结婚之前，置办婚礼
 * 结婚了开心
 * 结婚之后，收尾款
 */
public class StaticProxy {
    public static void main(String[] args) {

        //Thread代理真实对象Runnable接口
        new Thread(()-> {
            System.out.println("I Love You");
        }).start();

        //WeddingCompany代理You
        new WeddingCompany(new You()).HappyMarry();

    }
}

//接口结婚
interface Marry{
    void HappyMarry();
}

//真实角色,你去结婚
class You implements Marry {

    @Override
    public void HappyMarry() {
        System.out.println("结婚了开心");
    }
}

//代理角色，婚庆公司代理结婚
class WeddingCompany implements Marry{

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        //结婚之前
        before();
        //目标对象YOU结婚
        this.target.HappyMarry();
        //结婚之后
        after();
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }

    private void before() {
        System.out.println("结婚之前，置办婚礼");
    }
}