package com.xyy.reflect;


import com.sun.nio.zipfs.ZipPath;

/**
 * @author XYY
 * @version Id: ClassLoaderTest.java, v 0.1 2018/8/3 9:26 xuyuanye Exp $$
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        System.out.println(ClassLoaderTest.class.getClassLoader().getParent());
        System.out.println(ZipPath.class.getClassLoader().getParent());
        System.out.println(String.class.getClassLoader().getParent());
    }
}
