package com.xyy.thread;

import java.util.concurrent.TimeUnit;

/**
 * 线程结束方法
 * 1，线程自行运行结束。2，手动设置结束标志位。3，使用线程中断（interrupt）
 * Created by Administrator on 2017/11/5.
 */
public class ThreadInterrupted {

    public static void main(String [] args){
        try {
            //threadStopFlag();
            threadInterrupted();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 手动设置结束标志位
     */
     static void threadStopFlag() throws InterruptedException {
        ThreadStopFlagTest threadStopFlagTest = new ThreadStopFlagTest();
        new Thread(threadStopFlagTest).start();
        TimeUnit.SECONDS.sleep(5);
        threadStopFlagTest.stopMe();

    }

    /**
     * 使用线程中断
     */
    static void threadInterrupted() throws InterruptedException {
        ThreadInterruptedTest threadInterruptedTest = new ThreadInterruptedTest();
        Thread thread = new Thread(threadInterruptedTest);
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        thread.interrupt();

    }


     static class ThreadStopFlagTest implements Runnable{

        private boolean stopMe = false;

        public void run() {
            while(true){

                if(stopMe){
                    System.out.println("exit by stop me");
                    break;
                }

                try {
                    System.out.println("sleep 10 seconds");
                    //手动设置标志位无法停止wait()，sleep()操作
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

        public void stopMe(){
            stopMe = true;
        }
    }



    static class ThreadInterruptedTest implements Runnable{

        public void run() {
            while(true){

                if(Thread.currentThread().isInterrupted()){
                    System.out.println("thread is Interrupted");
                    break;
                }

                try {
                    System.out.println("sleep 10 seconds");
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                    //InterruptedException 异常会清楚中断标志位，因此要重置中断标志位
                    Thread.currentThread().interrupt();
                }
            }

        }
    }


}
