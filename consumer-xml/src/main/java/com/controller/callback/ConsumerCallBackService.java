package com.controller.callback;

import com.service.CallbackListener;
import com.service.CallbackService;
import com.service.GroupDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Star on 2018/2/28.
 */
@Component
public class ConsumerCallBackService {
    @Autowired
    private CallbackService callbackService;

    public String sayHello(String name) {
        callbackService.addListener("http://10.20.160.198/wiki/display/dubbo/foo.bar", new CallbackListener(){
            public void changed(String msg) {
                System.out.println("callback1:" + msg);
            }
        });
        return null;
    }
}
