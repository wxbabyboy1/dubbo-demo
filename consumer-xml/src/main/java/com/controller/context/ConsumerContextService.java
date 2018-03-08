package com.controller.context;

import com.service.ContextAAService;
import com.service.MockDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Star on 2018/2/28.
 */
@Component
public class ConsumerContextService {
    @Autowired
    private ContextAAService aaService;

    public void sayHello() {
        aaService.xxx();
    }
}
