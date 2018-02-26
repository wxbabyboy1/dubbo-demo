package com.alibaba.dubbo;


import com.alibaba.dubbo.provider.DemoService;
import com.alibaba.dubbo.provider.GroupDemoService;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.alibaba.dubbo.validate.ValidationParameter;
import com.alibaba.dubbo.provider.ValidationService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Star on 2018/2/24.
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"META-INF/spring/dubbo-demo-consumer.xml"});
        context.start();
        // obtain proxy object for remote invocation
        DemoService demoService = (DemoService) context.getBean("demoService");
        // execute remote invocation
        String hello = demoService.sayHello("world");
        // show the result
        System.out.println(hello);


        GroupDemoService group1 = (GroupDemoService) context.getBean("groupDemoService1");
        for(Integer num : group1.sayGroup()){
            System.out.println(num);
        }
        System.out.println("*****************");

        GroupDemoService group2 = (GroupDemoService) context.getBean("groupDemoService2");
        for(Integer num : group2.sayGroup()){
            System.out.println(num);
        }
        System.out.println("*****************");

        GroupDemoService mergeService1 = (GroupDemoService) context.getBean("mergeService1");
        for(Integer num : mergeService1.sayGroup()){
            System.out.println(num);
        }
        System.out.println("*****************");

        GroupDemoService mergeService2 = (GroupDemoService) context.getBean("mergeService2");
        for(Integer num : mergeService2.sayGroup()){
            System.out.println(num);
        }
        System.out.println("*****************");

        ValidationService validationService = (ValidationService)context.getBean("validationService");
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
        System.out.println("*****************");

        //泛化,获取pojo
        GenericService genericService = (GenericService) context.getBean("genericDemoService");
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

        //泛化，传参pojo
        Map<String, Object> hiWorld = new HashMap<String, Object>();
        hiWorld.put("name", "张三");

        Object sayHiValue = genericService.$invoke("sayHi", new String[]{"com.alibaba.dubbo.pojo.HiWorld"}, new Object[]{hiWorld});
        System.out.println(sayHiValue);

    }
}
