package com.notify;

import com.service.EventService;
import com.service.bean.Person;

/**
 * Created by ZhaGuolong on 2018/2/27.
 */
public class EventServiceImpl implements EventService {
    public Person get(int id) {
//        int a = 1/0;
        Person person = new Person(id, "charles`son", 4);
        return person;
    }
}
