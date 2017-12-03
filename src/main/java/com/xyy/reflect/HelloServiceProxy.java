package com.xyy.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 * Created by Administrator on 2017/12/3.
 */
public class HelloServiceProxy implements InvocationHandler {

    private Object target;
    public HelloServiceProxy(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("准备说");
        return method.invoke(target,args);
    }

    public static void main(String[] args) throws Exception {
        HelloService helloService = new HelloServiceImpl();
        HelloServiceProxy helloServiceProxy = new HelloServiceProxy(helloService);
        HelloService proxy = (HelloService)Proxy.newProxyInstance(helloService.getClass().getClassLoader(),
                helloService.getClass().getInterfaces(),helloServiceProxy);
        proxy.sayHello(" proxy");
    }

}
