package com.service;


import com.service.bean.HiWorld;

/**
 *
 * Created by ZhaGuolong on 2018/2/26.
 */
public interface GenericDemoService {
    String sayHi(HiWorld world);
    HiWorld getHi(String name);
}
