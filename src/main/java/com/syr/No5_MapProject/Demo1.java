package com.syr.No5_MapProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * 疫情地图实战第一天
 * @author syr
 * // TODO: 2020/12/1
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        //一门语言，与计算机交互的语言
        //自动关机
//        Runtime.getRuntime().exec("shutdown -s -t 3600");
        //取消自动关机
//        Runtime.getRuntime().exec("shutdown -a");

        /*访问网络资源*/
        /*将中文编码*/
        //String content = URLEncoder.encode("小王子","UTF-8");
        /*准备一个URL对象*/
        URL url=new URL("https://itdage.com/kkb/kkbsms?key=xzk&number=13253357452&code=123654");
        /*连接服务器*/
        URLConnection conn = url.openConnection();
        /*加载网络资源，字节输入流*/
        InputStream is = conn.getInputStream();
        /*将is装饰为能一次读取一行的字符缓冲输入流*/
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        /*读取一行资源*/
        String text = br.readLine();
        /*显示*/
        System.out.println(text);
        /*关闭连接*/
        br.close();


    }
}
