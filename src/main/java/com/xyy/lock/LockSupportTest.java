package com.xyy.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author XYY
 * @version Id: LockSupportTest.java, v 0.1 2018/11/27 9:19 xuyuanye Exp $$
 */
public class LockSupportTest {
    public static void main(String[] args) {
        System.out.println("LockSupportTest begin");
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                long start = System.currentTimeMillis();
                long end = 0L;
                while(end-start<=2000){
                    end=System.currentTimeMillis();
                }
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("LockSupportTest t1 park");
                //t1线程阻塞
                LockSupport.park(LockSupportTest.class);
                //t1线程阻塞
                LockSupport.park(LockSupportTest.class);
                System.out.println("LockSupportTest t1 unpark");
                LockSupport.parkNanos(LockSupportTest.class,1000000000L);
                System.out.println("LockSupportTest t1 parkNanos");
            }
        });
        t1.start();
        //唤醒线程t1
        t1.interrupt();
        //LockSupport.unpark(t1);
       // LockSupport.unpark(t1);
        System.out.println("LockSupportTest end");
    }
}

