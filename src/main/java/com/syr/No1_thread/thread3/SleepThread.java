package com.syr.No1_thread.thread3;

/**
 * @author syr
 * TODO: 2020/11/26
 * 须知：
 * 1.sleep指定当前线程阻塞的毫秒数
 * 2.存在InterruptedException异常
 * 3.sleep时间达到后线程进入就绪状态
 * 4.可以模拟网络延时，倒计时
 * 5.每个对象都有一把锁，sleep不会释放锁
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 1.模拟网络延时(放大问题发生性)  sleep(1000)->1s
 * 2.模拟倒计时
 * 3.模拟打印当前时间
 */
public class SleepThread {

    public static void tenDown() throws InterruptedException {
        int num=10;

        while(true){
            /*每隔一秒输出数字，睡眠一秒*/
            Thread.sleep(1000);
            System.out.println(num--);
            if(num<=0){
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //2.模拟倒计时
        //tenDown();

        //3.模拟打印系统当前时间
        Date starttime = new Date(System.currentTimeMillis());

        while(true){
            Thread.sleep(1000);
            //打印当前时间
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(starttime));
            //更新时间
            starttime = new Date(System.currentTimeMillis());
        }
    }

}
