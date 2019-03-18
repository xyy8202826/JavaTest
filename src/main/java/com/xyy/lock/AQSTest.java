package com.xyy.lock;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author XYY
 * @version Id: AQSTest.java, v 0.1 2019/2/15 15:54 xuyuanye Exp $$
 */
public class AQSTest {
    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        new Thread(new Runnable() {
            public void run() {
                reentrantLock.lock();
            }
        }).start();

    }

}

