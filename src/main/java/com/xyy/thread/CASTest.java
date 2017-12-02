package com.xyy.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**CASTest
 * 用户余额小于20元帮用户充值20元，多个线程来处理充值和消费
 * Created by Administrator on 2017/11/12.
 */
public class CASTest {
    private static  AtomicInteger ai = new AtomicInteger();
    private static  AtomicReference<Integer> ar = new AtomicReference<Integer>(15);
    private static  AtomicStampedReference<Integer> asr = new AtomicStampedReference<Integer>(15,0);
    public static void main(String [] args){
        //atomicReferenceTest();
        atomicStampedReferenceTest();
    }

    /**
     * 发生多次充值现象，因为账户余额被反复修改出现了ABA问题
     */
    private static  void atomicReferenceTest(){
        //充值线程
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                public void run() {
                    while(true){
                        Integer money = ar.get();
                        if(money<20){
                            if(ar.compareAndSet(money,money+20)){
                                System.out.println("余额小于20 充值成功，余额："+ar.get());
                                break;
                            }
                        }else{
                            System.out.println("余额大于等于20,退出：");
                            break;
                        }
                    }
                }
            }).start();
        }
        //消费线程
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                public void run() {
                    while(true){
                        Integer money = ar.get();
                        if(money>=10){
                            if(ar.compareAndSet(money,money-10)){
                                System.out.println("大于10元 消费10元成功，余额："+ar.get());
                                break;
                            }
                        }else{
                            System.out.println("余额小于10元,退出：");
                            break;
                        }
                    }
                }
            }).start();
        }
    }


    /**
     * 带有时间戳的对象引用可以避免ABA问题，用户只会充值一次
     */
    private static  void atomicStampedReferenceTest(){
        //充值线程
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                public void run() {
                    while(true){
                        Integer money = asr.getReference();
                        int stamp = asr.getStamp();
                        if(money<20){
                            if(asr.compareAndSet(money,money+20,stamp,stamp+1)){
                                System.out.println("余额小于20 充值成功，余额："+ar.get());
                                break;
                            }
                        }else{
                            System.out.println("余额大于等于20,退出：");
                            break;
                        }
                    }
                }
            }).start();
        }
        //消费线程
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                public void run() {
                    while(true){
                        Integer money = asr.getReference();
                        int stamp = asr.getStamp();
                        if(money>=10){
                            if(asr.compareAndSet(money,money-10,stamp,stamp+1)){
                                System.out.println("大于10元 消费10元成功，余额："+ar.get());
                                break;
                            }
                        }else{
                            System.out.println("余额小于10元,退出：");
                            break;
                        }
                    }
                }
            }).start();
        }
    }
}
