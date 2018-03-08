package com.controller.group;

import com.service.GroupDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Star on 2018/2/28.
 */
@Component
public class ConsumerGroupService {
    @Autowired
    private GroupDemoService groupDemoService1;

    @Autowired
    private GroupDemoService groupDemoService2;

    public String sayHello(String name) {
        List<Integer> list = groupDemoService1.sayGroup();

        List<Integer> list1 = groupDemoService2.sayGroup();
        return null;
    }
}
