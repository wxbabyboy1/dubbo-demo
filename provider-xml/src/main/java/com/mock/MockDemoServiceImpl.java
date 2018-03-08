package com.mock;

import com.service.MockDemoService;

/**
 * Created by Star on 2018/2/27.
 */
public class MockDemoServiceImpl implements MockDemoService {
    public String sayMock(String name) {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hi :" + name;
    }
}
