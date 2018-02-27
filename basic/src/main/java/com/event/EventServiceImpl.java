package com.event;

/**
 * Created by ZhaGuolong on 2018/2/27.
 */
public class EventServiceImpl implements EventService {
    public Person get(int id) {
        return new Person(id, "charles`son", 4);
    }
}
