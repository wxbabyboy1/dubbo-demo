package com.controller.mock;

import com.service.MockDemoService;
import com.service.P2XmlService;
import com.service.ProviderXmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Star on 2018/2/28.
 */
@Component
public class ConsumerMockService {
    @Autowired
    private MockDemoService mockDemoService;

    public String sayHello(String name) {
        return mockDemoService.sayMock(name);
    }
}
