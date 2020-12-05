package com.syr.No1_Thread.thread4;

import java.util.ArrayList;
import java.util.List;

/**
 * 三大不全的案例：1.不安全的买票+2.不安全的取钱+3.不安全的集合ArrayList
 * @author syr
 * // TODO: 2020/11/27
 * 3.不安全的集合ArrayList->锁的是往list中添加数据
 */
public class UnsafeList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            //不安全的原因：可能两个线程操作了同一个位置，导致两个位置上的内容被覆盖了
            new Thread( ()->{
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(1000);
        //集合大小，等于10000说明是安全的，斗则说明该集合不安全
        System.out.println(list.size());
    }

}
