package com.controller.generic;

import com.alibaba.dubbo.rpc.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Star on 2018/2/28.
 */
@RestController
public class GenericController {
    @Autowired
    ConsumerGenericService consumerGenericService;

    @RequestMapping(value = "/gen", method = RequestMethod.GET)
    public String sayWorld(String name) {
        String say = consumerGenericService.sayHello(name);
        return "Hello " + say;
    }
}
