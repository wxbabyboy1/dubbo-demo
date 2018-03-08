package com.controller.callback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Star on 2018/2/28.
 */
@RestController
public class CallBackController {
    @Autowired
    ConsumerCallBackService consumerCallBackService;

    @RequestMapping(value = "/callbk", method = RequestMethod.GET)
    public String sayWorld(String name) {
        String say = consumerCallBackService.sayHello(name);
        return "Hello " + say;
    }
}
