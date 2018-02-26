package com.alibaba.dubbo;


import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.provider.*;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.registry.RegistryFactory;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.service.EchoService;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.alibaba.dubbo.validate.ValidationParameter;
import com.callback.CallbackListener;
import com.callback.CallbackService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

/**
 * Created by Star on 2018/2/24.
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"META-INF/spring/dubbo-demo-consumer.xml"});
        context.start();

        /*
        // obtain proxy object for remote invocation
        DemoService demoService = (DemoService) context.getBean("demoService");
        // execute remote invocation
        String hello = demoService.sayHello("world");
        // show the result
        System.out.println(hello);


        //回声测试，所有服务都自动实现回声测试
        EchoService echoService = (EchoService) demoService; // 强制转型为EchoService
        // 回声测试可用性
        Object status = echoService.$echo("OK");
        System.out.println(status.equals("OK"));
//        assert(status.equals("OK"));
        System.out.println("*********回声测试end********");
        */

        //分组
        /*GroupDemoService group1 = (GroupDemoService) context.getBean("groupDemoService1");
        for(Integer num : group1.sayGroup()){
            System.out.println(num);
        }
        System.out.println("*****************");

        GroupDemoService group2 = (GroupDemoService) context.getBean("groupDemoService2");
        for(Integer num : group2.sayGroup()){
            System.out.println(num);
        }
        System.out.println("*****************");*/

        //分组聚合
        /*GroupDemoService mergeService1 = (GroupDemoService) context.getBean("mergeService1");
        for(Integer num : mergeService1.sayGroup()){
            System.out.println(num);
        }
        System.out.println("*****************");*/

        //分组聚合，自定义扩展点合并
        /*GroupDemoService mergeService2 = (GroupDemoService) context.getBean("mergeService2");
        for(Integer num : mergeService2.sayGroup()){
            System.out.println(num);
        }
        System.out.println("*****************");*/

        //验证
        /*ValidationService validationService = (ValidationService)context.getBean("validationService");
        //Error
        try {
            ValidationParameter parameter = new ValidationParameter();
            validationService.save(parameter);
            System.out.println("Validation ERROR");
        } catch (RpcException e) { // 抛出的是RpcException
            ConstraintViolationException ve = (ConstraintViolationException) e.getCause(); // 里面嵌了一个ConstraintViolationException
            Set<ConstraintViolation<?>> violations = ve.getConstraintViolations(); // 可以拿到一个验证错误详细信息的集合
            System.out.println(violations);
        }
        System.out.println("*****************");*/

        //泛化,获取pojo
        /*GenericService genericService = (GenericService) context.getBean("genericDemoService");
        Object result = genericService.$invoke("getHi", new String[] { "java.lang.String" }, new Object[] { "World" });
        HashMap<String, Object> userMap=(HashMap<String, Object>) result;
        for(Map.Entry<String, Object> entry1: userMap.entrySet()){
            if(entry1.getValue() instanceof HashMap){
                HashMap<String, Object> computerMap=(HashMap<String, Object>) entry1.getValue();
                System.out.println(entry1.getKey());
                for(Map.Entry<String, Object> entry: computerMap.entrySet()){
                    System.out.println("\t"+entry.getValue());
                }
            }else{
                System.out.println(entry1.getKey()+" "+entry1.getValue());
            }
        }
        System.out.println("*****************");

        //泛化，传参pojo
        Map<String, Object> hiWorld = new HashMap<String, Object>();
        hiWorld.put("name", "张三");
        Object sayHiValue = genericService.$invoke("sayHi", new String[]{"com.alibaba.dubbo.pojo.HiWorld"}, new Object[]{hiWorld});
        System.out.println(sayHiValue);
        System.out.println("*****************");*/

        //上下文
        /*ContextAAService contextAAService = (ContextAAService) context.getBean("contextAAService");
        contextAAService.xxx();*/

        //异步调用
        /*AsyncDemoAAService asyncAAService = (AsyncDemoAAService) context.getBean("asyncDemoAAService");
        String aa1 = asyncAAService.findAA();
        System.out.println(aa1);
        Future<String> aaFuture = RpcContext.getContext().getFuture();

        AsyncDemoBBService asyncBBService = (AsyncDemoBBService) context.getBean("asyncDemoBBService");
        String bb1 = asyncBBService.findBB();
        System.out.println(bb1);
        Future<String> bbFuture = RpcContext.getContext().getFuture();

        String aa = aaFuture.get();
        String bb = bbFuture.get();
        System.out.println(aa);
        System.out.println(bb);*/

        //参数回调
        /*CallbackService callbackService = (CallbackService) context.getBean("callbackService");

        callbackService.addListener("http://10.20.160.198/wiki/display/dubbo/foo.bar", new CallbackListener(){
            public void changed(String msg) {
                System.out.println("callback1:" + msg);
            }
        });

        Thread.sleep(9000);*/

        RegistryFactory registryFactory = ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
        Registry registry = registryFactory.getRegistry(URL.valueOf("zookeeper://127.0.0.1:2181"));
        registry.register(URL.valueOf("override://0.0.0.0/com.alibaba.dubbo.provider.DemoService?category=configurators&dynamic=false&application=demo-provider&mock=force:return+null"));

        DemoService demoService = (DemoService) context.getBean("demoService");
        String hello = demoService.sayHello("world");
        System.out.println(hello);
    }
}
