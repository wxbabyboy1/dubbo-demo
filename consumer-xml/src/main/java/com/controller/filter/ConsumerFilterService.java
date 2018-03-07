package com.controller.filter;

import com.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ZhaGuolong on 2018/3/7.
 */
@Component
public class ConsumerFilterService {
    @Autowired
    FilterService filterService;

    public String sayFilter(){
        return filterService.sayFilter("name");
    }
}
