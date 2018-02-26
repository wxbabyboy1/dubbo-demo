package com.alibaba.dubbo.provider;

import com.alibaba.dubbo.pojo.HiWorld;

/**
 * Created by ZhaGuolong on 2018/2/26.
 */
public class GenericDemoServiceImpl implements GenericDemoService {
    public String sayHi(HiWorld world) {
        System.out.println("hi " + world.getName());
        return  "hi " + world.getName();
    }

    public HiWorld getHi(String name) {
        HiWorld hiWorld = new HiWorld();
        hiWorld.setName(name);
        return hiWorld;
    }
}
