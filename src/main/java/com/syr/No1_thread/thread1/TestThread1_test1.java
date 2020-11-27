package com.syr.No1_thread.thread1;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 问题一：下载图片（多线程）
 * 继承Thread类
 * ===========================
 * @author syr
 * TODO: 2020/11/18
 */
public class TestThread1_test1 extends Thread{

    //网络图片地址
    public String url;
    //保存文件名
    public String name;

    public TestThread1_test1(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.webdownloader(url,name);
        System.out.println("下载了图片"+name);
    }

    public static void main(String[] args) {
        TestThread1_test1 t1 = new TestThread1_test1("https://img-blog.csdnimg.cn/20200926154952360.png","t1");
        TestThread1_test1 t2 = new TestThread1_test1("https://img-blog.csdnimg.cn/20200926154959120.png","t2");
        TestThread1_test1 t3 = new TestThread1_test1("https://img-blog.csdnimg.cn/20200926155039323.png","t3");

        t1.start();
        t2.start();
        t3.start();
    }
}

//下载器
class WebDownloader{

    //下载方法
    public void webdownloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            System.out.println("下载异常");
            e.printStackTrace();
        }
    }

}
