package com.consumer.controller;

import com.consumer.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Star on 2018/2/28.
 */
@RestController
public class TestController {
    @Autowired
    private HiService hiService;

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String sayWorld(String name) {
        hiService.say(name);
        return "Hello " + name;
    }
}
