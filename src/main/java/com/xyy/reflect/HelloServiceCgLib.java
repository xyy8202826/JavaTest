package com.xyy.reflect;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib实现动态代理
 * Created by Administrator on 2017/12/3.
 */
public class HelloServiceCgLib implements MethodInterceptor{


    private Object target;

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib实现动态代理");
        System.out.println("准备说");
        Object obj = methodProxy.invokeSuper(o,objects);
        System.out.println("说完了");
        return obj;
    }

    public Object getInstance(Object target){

        this.target=target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public static void main(String[] args) throws Exception {
        HelloService helloService = new HelloServiceImpl();
        HelloServiceCgLib helloServiceCgLib = new HelloServiceCgLib();
        HelloService proxy = (HelloService)helloServiceCgLib.getInstance(helloService);
        proxy.sayHello("HelloServiceCgLib");
    }
}
