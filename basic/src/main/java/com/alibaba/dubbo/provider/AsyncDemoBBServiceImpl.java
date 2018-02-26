package com.alibaba.dubbo.provider;

/**
 * Created by ZhaGuolong on 2018/2/26.
 */
public class AsyncDemoBBServiceImpl implements AsyncDemoBBService {
    public String findBB() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "findBB-----------";
    }
}
