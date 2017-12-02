package com.xyy.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** ThreadLocal 测试
 * Created by Administrator on 2017/11/12.
 */
public class ThreadLocalTest {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

   private static ThreadLocal<SimpleDateFormat> ts = new ThreadLocal<SimpleDateFormat>();

   public static void main(String [] args){
        //simpleDateFormatNotThreadLocal();
        simpleDateFormatThreadLocal();

    }

    /**
     * SimpleDateFormat 不是线程安全的，会出现下面异常
     * Exception in thread "pool-1-thread-12" java.lang.NumberFormatException: multiple points
     */
    private static void simpleDateFormatNotThreadLocal(){
        ExecutorService es = Executors.newFixedThreadPool(10);
        for(int i=0 ;i<10000 ;i++){
            es.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(sdf.parse("2017-11-12 15:25:20"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }


    private static void simpleDateFormatThreadLocal(){
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i=0 ;i<1000 ;i++){
            es.execute(new Runnable() {
                public void run() {
                    try {
                        if(ts.get() == null){
                            ts.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                        }
                        SimpleDateFormat sf = ts.get();
                        System.out.println(sf.parse("2017-11-12 15:25:20"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }


}
