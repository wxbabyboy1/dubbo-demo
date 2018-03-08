package com.genericImpl;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;

/**
 * Created by Star on 2018/3/8.
 */
public class MyGenericService implements GenericService {
    @Override
    public Object $invoke(String methodName, String[] parameterTypes, Object[] args) throws GenericException {
        if ("sayHello".equals(methodName)) {
            return "Welcome " + args[0];
        }
        return null;
    }
}
