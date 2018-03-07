package com.controller.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Star on 2018/2/28.
 */
@RestController
public class HelloController {
    @Autowired
    ConsumerService consumerService;

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String sayWorld(String name) {
        String say = consumerService.sayHello(name);
        System.out.println(say);
        return "Hello " + say;
    }
}
