package com.qf.shop.service.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by 李杰 on 2018/9/21.
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext(new String []{"spring-provider.xml"});
        ctx.start();
        /*长连接  保持一直处于运行状态*/
        System.in.read();
    }
}
