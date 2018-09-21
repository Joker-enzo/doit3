package com.qf.shop.service.main;

import com.qf.shop.service.DemoService;
import com.qf.shop.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 李杰 on 2018/9/21.
 */
public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext(new String[]{"spring-consumer.xml"});

        ctx.start();
        //获取远程代理对象
        DemoService service = (DemoService) ctx.getBean("demoService");

        System.out.println(service.sayHello("你好"));
        System.out.println("=====================================================");
        HelloService helloService = (HelloService) ctx.getBean("helloService");

        System.out.println( helloService.say("中国"));

    }
}
