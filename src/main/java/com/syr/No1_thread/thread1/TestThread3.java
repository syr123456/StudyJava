package com.syr.No1_thread.thread1;

import java.util.concurrent.*;

/**
 * 创建线程方式三：实现Callable
 * 1.创建子类对象
 *   TestThread3 t1 = new TestThread3("https://img-blog.csdnimg.cn/20200926154952360.png","t1");
 * 2.创建执行服务
 *   ExecutorService ser = Executors.newFixedThreadPool(3);
 * 3.提交执行
 *   Future<Boolean> r1 = ser.submit(t1);
 * 4.获取结果
 *   boolean rs1 = r1.get();
 * 5.关闭服务
 *   ser.shutdownNow();
 * 注意Callable好处：
 * （1）可以定义返回值
 * （2）可以抛出异常
 *
 * @author syr
 * TODO: 2020/11/19
 */
public class TestThread3 implements Callable<Boolean> {

    //网络图片地址
    public String url;
    //保存文件名
    public String name;

    public TestThread3(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.webdownloader(url,name);
        System.out.println("下载了图片"+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //main方法，主线程
        TestThread3 t1 = new TestThread3("https://img-blog.csdnimg.cn/20200926154952360.png","t1");
        TestThread3 t2 = new TestThread3("https://img-blog.csdnimg.cn/20200926154959120.png","t2");
        TestThread3 t3 = new TestThread3("https://img-blog.csdnimg.cn/20200926155039323.png","t3");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        //获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        //关闭服务
        ser.shutdownNow();
    }
}