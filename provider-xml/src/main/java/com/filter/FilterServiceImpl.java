package com.filter;


import com.service.FilterService;

/**
 * Created by Star on 2018/2/24.
 */
public class FilterServiceImpl implements FilterService {
    public String sayFilter(String name) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Filter " + name;
    }
}
