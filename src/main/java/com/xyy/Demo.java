package com.xyy;

/**
 * @author XYY
 * @version Id: Demo.java, v 0.1 2018/11/13 21:40 xuyuanye Exp $$
 */
public class Demo {
    String demoName;

    public Demo(String demoName) {
        this.demoName = demoName;
    }

    public String getDemoName() {
        return demoName;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "demoName='" + demoName + '\'' +
                '}';
    }
}

