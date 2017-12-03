package com.xyy.reflect;


/**
 * 反射测试
 * Created by Administrator on 2017/12/3.
 */
public class ReflectService {
    static {
        System.out.println("ReflectService static {}");
    }


    public static void main(String[] args) throws Exception {
        System.out.println(ReflectService.class.getName());
        //反射获取class
        Class calzz = Class.forName(ReflectService.class.getName());
        //实例化对象
        ReflectService reflectService = (ReflectService)calzz.newInstance();
        reflectService.sayHello();
    }

    public void sayHello(){
        System.out.println("Hello");
    }
}
