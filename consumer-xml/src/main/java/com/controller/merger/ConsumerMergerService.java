package com.controller.merger;

import com.service.GroupDemoService;
import com.service.MockDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Star on 2018/2/28.
 */
@Component
public class ConsumerMergerService {
    @Autowired
    private GroupDemoService mergeService1;

    @Autowired
    private GroupDemoService mergeService2;

    public String sayHello(String name) {
        List<Integer> list = mergeService1.sayGroup();

        List<Integer> list1 = mergeService2.sayGroup();
        return null;
    }
}
