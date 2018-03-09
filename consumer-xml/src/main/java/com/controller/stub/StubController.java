package com.controller.stub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Star on 2018/2/28.
 */
@RestController
public class StubController {
    @Autowired
    ConsumerStubService consumerStubService;

    @RequestMapping(value = "/stub", method = RequestMethod.GET)
    public String sayWorld(String name) {
        String say = consumerStubService.sayHello(name);
        System.out.println(say);
        return "Hello " + say;
    }
}
