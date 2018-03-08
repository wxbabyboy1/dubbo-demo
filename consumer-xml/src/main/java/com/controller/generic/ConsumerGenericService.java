package com.controller.generic;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.service.GenericDemoService;
import com.service.bean.HiWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Star on 2018/2/28.
 */
@Component
public class ConsumerGenericService {
    @Autowired
    private GenericService genericDemoService;

    public String sayHello(String name) {
        Object result = genericDemoService.$invoke("getHi", new String[] { "java.lang.String" }, new Object[] { "World" });
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
        Object sayHiValue = genericDemoService.$invoke("sayHi", new String[]{"com.service.bean.HiWorld"}, new Object[]{hiWorld});
        System.out.println(sayHiValue);

//        HiWorld hi = genericDemoService.getHi(name);
//        return genericDemoService.sayHi(hi);
        return null;
    }
}
