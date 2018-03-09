package com.controller.stub;

import com.service.GroupDemoService;
import com.service.StubDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Star on 2018/2/28.
 */
@Component
public class ConsumerStubService {
    @Autowired
    private StubDemoService stubDemoService;

    public String sayHello(String name) {
        return stubDemoService.sayHello(name);
    }
}
