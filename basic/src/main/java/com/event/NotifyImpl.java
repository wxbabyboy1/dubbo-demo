package com.event;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhaGuolong on 2018/2/27.
 */
public class NotifyImpl implements Notify {
    public Map<Integer, Person> ret    = new HashMap<Integer, Person>();
    public Map<Integer, Throwable> errors = new HashMap<Integer, Throwable>();

    public void onreturn(Person msg, Integer id) {
        System.out.println("onreturn:" + msg);
        ret.put(id, msg);
    }

    public void onthrow(Throwable ex, Integer id) {
        errors.put(id, ex);
    }
}
