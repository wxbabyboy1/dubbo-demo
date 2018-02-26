package com;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Star on 2018/2/24.
 */
@SpringBootApplication
@DubboComponentScan(basePackages = "com.provider")
public class ProviderTestApp {
    public static void main(String[] args) {
        SpringApplication.run(ProviderTestApp.class, args);
    }
}
