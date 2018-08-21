package com.xyy.serializable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XYY
 * @version Id: SerializableTest.java, v 0.1 2017/12/8 15:56 xuyuanye Exp $$
 */
public class SerializableTest {

    public static void main(String[] args) throws Exception {
        //writeObject();
        readObject();
    }

    public static void writeObject() {
        try {
            SerializableDTO serializableDTO = new SerializableDTO();
            serializableDTO.setAge(12);
            serializableDTO.setName("name");
            //serializableDTO.setChina(true);
            File file = new File("F:\\Study\\SerializableTest");
            if(file.exists()){
                file.delete();
            }
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(serializableDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readObject() {
        try {
            File file = new File("F:\\Study\\SerializableTest");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            SerializableDTO serializableDTO = (SerializableDTO) ois.readObject();
            System.out.println(serializableDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
