package com.alibaba.dubbo.provider;

import com.alibaba.dubbo.pojo.HiWorld;

/**
 * Created by ZhaGuolong on 2018/2/26.
 */
public interface GenericDemoService {
    String sayHi(HiWorld world);
    HiWorld getHi(String name);
}
