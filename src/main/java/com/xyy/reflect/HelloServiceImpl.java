package com.xyy.reflect;

/**
 * Created by Administrator on 2017/12/3.
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        System.out.println("HelloServiceImpl Hello"+ name);
    }
}
