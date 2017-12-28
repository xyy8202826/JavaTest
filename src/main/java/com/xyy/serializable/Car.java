package com.xyy.serializable;

import java.io.Serializable;

/**
 * @author XYY
 * @version Id: Car.java, v 0.1 2017/12/8 15:52 xuyuanye Exp $$
 */
public class Car implements Serializable{
    private String name ;
    private Long price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
