package com.stub;

/**
 * Created by ZhaGuolong on 2018/2/27.
 */
public class StubDemoServiceStub implements StubDemoService {
    private final StubDemoService stubService;

    // 构造函数传入真正的远程代理对象
    public StubDemoServiceStub(StubDemoService stubService) {
        this.stubService = stubService;
    }

    public String sayHello(String name) {
        // 此代码在客户端执行, 你可以在客户端做ThreadLocal本地缓存，或预先验证参数是否合法，等等
        try {
            System.out.println("本地存根");
            return stubService.sayHello(name);
        } catch (Exception e) {
            // 你可以容错，可以做任何AOP拦截事项
            return "容错数据";
        }
    }
}
