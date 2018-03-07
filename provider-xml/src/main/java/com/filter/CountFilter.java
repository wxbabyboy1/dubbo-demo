package com.filter;

import com.alibaba.dubbo.rpc.*;

/**
 * Created by Star on 2018/2/25.
 */
public class CountFilter implements Filter {

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("==========CountFiler============");
        Result result = invoker.invoke(invocation);
        return result;
    }
}
