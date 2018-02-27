package com.mock;

/**
 * Created by Star on 2018/2/27.
 */
public class DescMockServiceImpl implements DescMockService {
    public String sayHello(String name) {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello " + name;
    }
}
