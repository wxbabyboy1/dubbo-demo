package com.controller.notify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Star on 2018/2/28.
 */
@RestController
public class NotifyController {
    @Autowired
    ConsumerEventService consumerEventService;

    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public String sayWorld() {
        String say = consumerEventService.sayHello();
        System.out.println(say);
        return "Hello " + say;
    }
}
