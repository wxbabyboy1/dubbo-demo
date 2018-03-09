package com.listener;

import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.InvokerListener;
import com.alibaba.dubbo.rpc.RpcException;

/**
 * Created by ZhaGuolong on 2018/3/9.
 */
public class AAListener implements InvokerListener {
    @Override
    public void referred(Invoker<?> invoker) throws RpcException {
        System.out.println("=====================================referred");
    }

    @Override
    public void destroyed(Invoker<?> invoker) {
        System.out.println("=====================================destroyed");

    }
}
