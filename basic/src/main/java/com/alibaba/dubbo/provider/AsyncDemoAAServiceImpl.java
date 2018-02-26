package com.alibaba.dubbo.provider;

/**
 * Created by ZhaGuolong on 2018/2/26.
 */
public class AsyncDemoAAServiceImpl implements AsyncDemoAAService {
    public String findAA() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  "findAA---------";
    }
}
