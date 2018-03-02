package com.service;


import java.time.LocalDateTime;

/**
 * Created by Star on 2018/2/24.
 */
public class ProviderXmlServiceImpl implements ProviderXmlService {
    public String sayHello(String name) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello " + name + LocalDateTime.now();
    }
}
