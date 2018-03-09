package com.validation;


import com.service.ValidationService;
import com.service.bean.ValidationParameter;

/**
 * Created by ZhaGuolong on 2018/2/26.
 */
public class ValidationServiceImpl implements ValidationService {
    public void save(ValidationParameter parameter) {
        int age = parameter.getAge();
    }

    public void update(ValidationParameter parameter) {

    }
}
