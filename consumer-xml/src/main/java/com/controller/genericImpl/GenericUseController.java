package com.controller.genericImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Star on 2018/2/28.
 */
@RestController
public class GenericUseController {
    @Autowired
    ConsumerGenericUseService useService;

    @RequestMapping(value = "/use", method = RequestMethod.GET)
    public String sayWorld(String name) {
        String say = useService.sayHello(name);
        return "Hello " + say;
    }
}
