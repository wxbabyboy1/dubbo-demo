package com.controller.notify;

import com.service.*;
import com.service.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Star on 2018/2/28.
 */
@Component
public class ConsumerEventService {
    @Autowired
    private EventService eventService;

    @Autowired
    private NotifyImpl notify;

    public String sayHello() {
        int requestId = 13;
        Person person = eventService.get(requestId);
        System.out.println(null == person);
        //for Test：只是用来说明callback正常被调用，业务具体实现自行决定.
        for(int i=0;i<=10;i++){
            if (!notify.ret.containsKey(requestId)) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(person);
        return notify.ret.get(requestId).getName();
    }
}
