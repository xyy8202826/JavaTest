package com.xyy.thread;

/**
 * @author XYY
 * @version Id: VolatileTest.java, v 0.1 2018/12/20 15:53 xuyuanye Exp $$
 */
public class VolatileTest extends Thread{
    boolean flag = false;
    int i = 0;
    @Override
    public void run() {
        while (!getFlag()) {
            i++;
        }
    }
    public synchronized boolean getFlag(){
        return flag;
    }
    public synchronized boolean setFlag(boolean flag){
        return this.flag=flag;
    }
    public static void main(String[] args) throws InterruptedException {
        VolatileTest vt = new VolatileTest();
        vt.start();
        Thread.sleep(2000L);
        vt.setFlag(true);
        System.out.println("stop:" + vt.i);
    }
}

