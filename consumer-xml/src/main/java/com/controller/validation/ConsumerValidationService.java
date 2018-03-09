package com.controller.validation;

import com.alibaba.dubbo.rpc.RpcException;
import com.service.ValidationService;
import com.service.bean.ValidationParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * Created by Star on 2018/2/28.
 */
@Component
public class ConsumerValidationService {
    @Autowired
    private ValidationService validationService;

    public String sayHello() {
        //Error
        try {
            ValidationParameter parameter = new ValidationParameter();
            validationService.save(parameter);
            System.out.println("Validation ERROR");
        } catch (RpcException e) { // 抛出的是RpcException
            ConstraintViolationException ve = (ConstraintViolationException) e.getCause(); // 里面嵌了一个ConstraintViolationException
            Set<ConstraintViolation<?>> violations = ve.getConstraintViolations(); // 可以拿到一个验证错误详细信息的集合
            System.out.println("====================rpcException:");
            for (ConstraintViolation<?> violation : violations) {
                Field[] fields = violation.getClass().getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    try {
                        System.out.println("============="+field.get(violation));
                    } catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ValidationParameter parameter = new ValidationParameter();
        parameter.setName("3224");
        parameter.setAge(34);
        Class<? extends ValidationParameter> aClass = parameter.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        System.out.println(declaredFields.length);
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object o = declaredField.get(parameter);
            System.out.println(o);

//            System.out.println(name + " ==================" + type.getName() + " ============" + s);

        }
//        .getDeclaredFields();
//        System.out.println(fields.length);
//        for (Field field : fields) {
//            field.setAccessible(true);
//            System.out.println(field.getName());
//        }
    }
}
