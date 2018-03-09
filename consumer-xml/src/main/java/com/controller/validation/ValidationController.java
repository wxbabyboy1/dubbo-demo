package com.controller.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Star on 2018/2/28.
 */
@RestController
public class ValidationController {
    @Autowired
    ConsumerValidationService consumerValidationService;

    @RequestMapping(value = "/vali", method = RequestMethod.GET)
    public String sayWorld() {
        String say = consumerValidationService.sayHello();
        System.out.println(say);
        return "Hello " + say;
    }
}
