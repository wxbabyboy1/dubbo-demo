package com.service;

import com.service.bean.Person;

/**
 * Created by ZhaGuolong on 2018/2/27.
 */
public interface Notify {
    public void onreturn(Person msg, Integer id);
    public void onthrow(Throwable ex, Integer id);
}
