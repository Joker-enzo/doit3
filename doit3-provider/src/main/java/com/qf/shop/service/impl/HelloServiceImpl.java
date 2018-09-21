package com.qf.shop.service.impl;

import com.qf.shop.service.HelloService;

/**
 * Created by 李杰 on 2018/9/21.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String say(String name) {
        return "Hello"+name;
    }
}
