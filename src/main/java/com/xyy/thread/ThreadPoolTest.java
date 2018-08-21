package com.xyy.thread;

import java.util.concurrent.*;

/**
 * 线程池停止测试
 *
 *
 */
public class ThreadPoolTest {

    private static ExecutorService executorService = new ThreadPoolExecutor(10,20,1, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(10),new ThreadFactory(){
        int i = 0;
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            System.out.println("ThreadPoolTest thread"+i++);
            return thread;
        }
    });

    public static void main(String [] args){
        System.out.println(executorService);
        for(int i= 0;i<20;i++){
            try{
                executorService.execute(new Runnable() {
                    public void run() {
                        try {
                            TimeUnit.SECONDS.sleep(2);
                            System.out.println(this.toString());
                        } catch (InterruptedException e) {
                            System.out.println("InterruptedException");
                        }
                    }
                });
            }catch (Exception e){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                System.out.println(e);
            }

        }
        System.out.println(executorService);
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(executorService);
        for(int i= 0;i<5;i++){
            try{
                executorService.execute(new Runnable() {
                    public void run() {
                        try {
                            TimeUnit.SECONDS.sleep(2);
                            System.out.println(this.toString());
                        } catch (InterruptedException e) {
                            System.out.println("InterruptedException");
                        }
                    }
                });
            }catch (Exception e){
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                System.out.println(e);
            }

        }
        System.out.println(executorService);
        shutdown();
      //  System.exit(0);
       // shutdownNow();
    }


    public static void shutdown(){
        executorService.shutdown();
        System.out.println("shutdown");
    }
    public static void shutdownNow(){
        executorService.shutdownNow();
        System.out.println("shutdownNow");
    }

}
