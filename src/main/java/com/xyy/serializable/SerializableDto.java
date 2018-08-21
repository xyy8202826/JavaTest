package com.xyy.serializable;

import java.io.Serializable;
import java.util.List;

/**
 * 序列化DTO
 * @author XYY
 * @version Id: SerializableDTO.java, v 0.1 2017/12/8 15:49 xuyuanye Exp $$
 */
public class SerializableDTO implements Serializable{
    private static final long serialVersionUID = -3019312668948463651L;
    private String name;
    private String add;
    private int age;
    private boolean china;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isChina() {
        return china;
    }

    public void setChina(boolean china) {
        this.china = china;
    }
    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public String toString() {
        return "SerializableDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", add=" + add +
                ", china=" + china +
                '}';
    }
}

