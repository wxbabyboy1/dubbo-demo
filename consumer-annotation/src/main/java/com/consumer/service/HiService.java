package com.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.service.ProviderAService;
import com.service.ProviderBService;
import com.service.bean.HiParam;
import org.springframework.stereotype.Component;

/**
 * Created by ZhaGuolong on 2018/2/28.
 */
@Component
public class HiService {
    @Reference(version = "1.0.1")
    private ProviderAService aService;

    @Reference(version = "1.0.2")
    private ProviderBService bService;

    public void say(String name){
        HiParam param = new HiParam();
        param.setName(name);
        String name1 = aService.getName(param);

        // 本端是否为提供端，这里会返回true
        boolean isProviderSide = RpcContext.getContext().isProviderSide();
        System.out.println("是否为提供端：" + isProviderSide);
        // 获取调用方IP地址
        String clientIP = RpcContext.getContext().getRemoteHost();
        System.out.println("调用方ip：" + clientIP);
        // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        String application = RpcContext.getContext().getUrl().getParameter("application");
        System.out.println("rpc的配置名：" + application);

        HiParam hiParam = bService.getHiParam(name);
        System.out.println(hiParam.getName());

        // 此时本端变成消费端，这里会返回false
        isProviderSide = RpcContext.getContext().isProviderSide();
        System.out.println("是否为提供端：" + isProviderSide);
    }
}
