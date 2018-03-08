package com.controller.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Star on 2018/2/28.
 */
@RestController
public class MockController {
    @Autowired
    ConsumerMockService mockService;

    @RequestMapping(value = "/mock", method = RequestMethod.GET)
    public String sayWorld(String name) {
        String say = mockService.sayHello(name);
        System.out.println(say);
        return "Hello " + say;
    }
}
