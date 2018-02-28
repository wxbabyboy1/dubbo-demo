package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Star on 2018/2/28.
 */
@SpringBootApplication
@ImportResource({"classpath:dubbo/dubbo-demo-provider.xml"})
public class ProviderMain {
    public static void main(String[] args) {
        SpringApplication.run(ProviderMain.class, args);
    }
}
