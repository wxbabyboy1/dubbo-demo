package com.controller.genericImpl;

import com.alibaba.dubbo.config.ServiceConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Star on 2018/2/28.
 */
@Component
public class ConsumerGenericUseService {

    @Autowired
    private BarService barService;

    public String sayHello(String name) {
        return barService.sayHello(name);
    }
}
