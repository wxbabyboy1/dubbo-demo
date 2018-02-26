package com;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.consumer.AnnotationConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Star on 2018/2/24.
 */
@SpringBootApplication
@DubboComponentScan(basePackages = "com.consumer")
public class ConsumerTestApp {
    @Autowired
    private AnnotationConsumeService service;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerTestApp.class, args);
    }

    @RequestMapping("/say")
    public String sayHello(String name){
        return service.annotateService.sayHello(name);
    }

}
