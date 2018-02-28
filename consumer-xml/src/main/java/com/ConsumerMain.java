package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Star on 2018/2/24.
 */
@SpringBootApplication
@ImportResource({"classpath:dubbo/dubbo-demo-consumer.xml"})
public class ConsumerMain {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ConsumerMain.class, args);
    }
}
