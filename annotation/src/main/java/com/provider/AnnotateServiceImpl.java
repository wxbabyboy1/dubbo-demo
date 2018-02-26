package com.provider;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * Created by Star on 2018/2/24.
 */
@Service(timeout = 5000)
public class AnnotateServiceImpl implements AnnotateService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
