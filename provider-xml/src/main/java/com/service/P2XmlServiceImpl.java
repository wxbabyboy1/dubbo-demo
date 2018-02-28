package com.service;


import com.service.bean.HelloParam;

/**
 * Created by Star on 2018/2/24.
 */
public class P2XmlServiceImpl implements P2XmlService {

    @Override
    public HelloParam say(String name, int num) {
        HelloParam helloParam = new HelloParam();
        helloParam.setName(name);
        helloParam.setNum(num);
        return helloParam;
    }
}
