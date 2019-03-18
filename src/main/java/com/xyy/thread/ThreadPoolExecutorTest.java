package com.xyy.thread;

import java.util.concurrent.*;

/**
 * @author XYY
 * @version Id: ThreadPoolExecutorTest.java, v 0.1 2018/8/29 14:41 xuyuanye Exp $$
 */
public class ThreadPoolExecutorTest {
    private final static ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.MINUTES,
            new ArrayBlockingQueue<Runnable>(1),new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       /* ThreadPoolExecutor executor = new ThreadPoolExecutor(1,5,1, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

        for(int i=0;i<5;i++){
            //executor.submit(getThread(i+""));
            Future<String> future = executor.submit(getThread("100"));
            System.out.println(future.get());
        }*/


        //(2)添加任务one
        Future futureOne = executorService.submit(new Runnable() {
            @Override
            public void run() {

                System.out.println("start runable one");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //(3)添加任务two
        Future futureTwo = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("start runable two");
            }
        });

        //(4)添加任务three
        Future futureThree=null;
        try {
            futureThree = executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("start runable three");
                }
            });
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }


        System.out.println("task one " + futureOne.get());//(5)等待任务one执行完毕
        System.out.println("task two " + futureTwo.get());//(6)等待任务two执行完毕
        System.out.println("task three " + (futureThree==null?null:futureThree.get()));// (7)等待任务three执行完毕


        executorService.shutdown();//(8)关闭线程池，阻塞直到所有任务执行完毕

    }

    public static Callable<String> getThread(final String name){
        return new Callable<String>() {
            public String call() throws Exception {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(name);
                return name;
            }
        };
    }
}
