package com.syr.No1_Thread.thread4;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author syr
 * // TODO: 2020/11/27
 * juc 并发包
 * 测试juc安全类型的集合
 */
public class JUCThread {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> copy = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread( ()->{
                copy.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(copy.size());
    }
}
