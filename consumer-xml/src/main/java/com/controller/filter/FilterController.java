package com.controller.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZhaGuolong on 2018/3/7.
 */
@RestController
public class FilterController {
    @Autowired
    ConsumerFilterService consumerFilterService;

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public String sayWorld() {
        String say = consumerFilterService.sayFilter();
        System.out.println(say);
        return "Hello " + say;
    }
}
