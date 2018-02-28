package com.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.service.P2XmlService;
import com.service.ProviderXmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Star on 2018/2/28.
 */
@Component
public class ConsumerService {
    @Autowired
    private ProviderXmlService providerXmlService;

    @Autowired
    private P2XmlService p2XmlService;

    public String sayHello(String name) {
        System.out.println(p2XmlService.say(name,1).getName());
        return providerXmlService.sayHello(name);
    }
}
