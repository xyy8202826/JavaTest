package com.xyy.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println();
        // 获取Class对象
        Class reflectDemoClass = ReflectDemo.class;
        //获取类方法：getMethods()
        Method[] methods = reflectDemoClass.getMethods();
        List<String> methodNames = new ArrayList<String>();
        for (Method method :methods){
            methodNames.add(method.getName());
        }
        System.out.println(methodNames);

        //获取类方法：getDeclaredMethods()
        Method[] declaredMethods = reflectDemoClass.getDeclaredMethods();
        List<String> declaredMethodNames = new ArrayList<String>();
        for (Method declaredMethod :declaredMethods){
            declaredMethodNames.add(declaredMethod.getName());
        }
        System.out.println(declaredMethodNames);

        //获取类属性：getFields()
        Field[] fields = reflectDemoClass.getFields();
        List<String> fieldNames = new ArrayList<String>();
        for (Field field :fields){
            fieldNames.add(field.getName());
        }
        System.out.println(fieldNames);
        //获取类属性：getDeclaredFields()
        Field[] declaredFields = reflectDemoClass.getDeclaredFields();
        List<String> declaredFieldNames = new ArrayList<String>();
        for (Field declaredField :declaredFields){
            declaredFieldNames.add(declaredField.getName());
        }
        System.out.println(declaredFieldNames);
    }
}
