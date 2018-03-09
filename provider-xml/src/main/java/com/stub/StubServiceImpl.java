package com.stub;


import com.service.StubDemoService;

/**
 * Created by Star on 2018/2/24.
 */
public class StubServiceImpl implements StubDemoService {
    public String sayHello(String name) {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Stub " + name;
    }
}
