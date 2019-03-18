package com.xyy;

import java.util.concurrent.TimeUnit;

/**
 * @author XYY
 * @version Id: SynchronousQueueTest.java, v 0.1 2018/11/20 15:07 xuyuanye Exp $$
 */
public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        final SemaphoreSynchronousQueue<String> ssq= new SemaphoreSynchronousQueue<String>();

        Thread t1 =new Thread(new Runnable() {
            public void run() {
                try {
                    for(;;){
                        String str = ssq.take();
                        System.out.println(str);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 =new Thread(new Runnable() {
            public void run() {
                try {
                    int i=0;
                    for(;;){
                        ssq.put(""+i++);
                        TimeUnit.SECONDS.sleep(1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
       t1.start();
       t2.start();

    }
}
