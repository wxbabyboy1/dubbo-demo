package com.controller.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Star on 2018/2/28.
 */
@RestController
public class TContextController {
    @Autowired
    ConsumerContextService consumerContextService;

    @RequestMapping(value = "/context", method = RequestMethod.GET)
    public String sayWorld() {
        consumerContextService.sayHello();
        return null;
    }
}
