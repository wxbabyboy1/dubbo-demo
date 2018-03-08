package com.context;

import com.alibaba.dubbo.rpc.RpcContext;
import com.service.ContextAAService;
import com.service.ContextBBService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ZhaGuolong on 2018/2/26.
 */
public class ContextAAServiceImpl implements ContextAAService {
    @Autowired
    ContextBBService contextBBService;

    public void xxx() {
        // 本端是否为提供端，这里会返回true
        boolean isProviderSide = RpcContext.getContext().isProviderSide();
        System.out.println("是否为提供端：" + isProviderSide);
        // 获取调用方IP地址
        String clientIP = RpcContext.getContext().getRemoteHost();
        System.out.println("调用方ip：" + clientIP);
        // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        String application = RpcContext.getContext().getUrl().getParameter("application");
        System.out.println("rpc的配置名：" + application);

        // 注意：每发起RPC调用，上下文状态会变化
        contextBBService.yyy();
        // 此时本端变成消费端，这里会返回false
        isProviderSide = RpcContext.getContext().isProviderSide();
        System.out.println("是否为提供端：" + isProviderSide);
    }
}
