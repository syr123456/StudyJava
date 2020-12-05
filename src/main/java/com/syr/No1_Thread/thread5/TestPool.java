package com.syr.No1_Thread.thread5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程池，类似Callable
 * @author syr
 * // TODO: 2020/11/27
 * 1.创建服务，创建线程池
 * 2.丢入线程，service.execute执行
 * 3.关闭链接
 */
public class TestPool {
    public static void main(String[] args) {
        //1.创建服务，创建线程池
        //newFixedThreadPool参数为线程池的大小
        ExecutorService service = Executors.newFixedThreadPool(10);

        //2.丢入线程，service.execute执行
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        //3.关闭链接
        service.shutdown();
    }

}

class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}