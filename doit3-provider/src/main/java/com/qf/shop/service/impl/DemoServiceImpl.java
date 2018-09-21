package com.qf.shop.service.impl;

import com.qf.shop.service.DemoService;

/**
 * Created by 李杰 on 2018/9/21.
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Demo" +name;
    }
}
