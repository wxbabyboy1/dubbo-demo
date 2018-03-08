package com.service;

/**
 * Created by Star on 2018/2/26.
 */
public interface CallbackService {
    void addListener(String key, CallbackListener listener);
}
