package com.xyy.thread;

import java.util.concurrent.*;

/**
 * @author XYY
 * @version Id: FutureTaskTest.java, v 0.1 2019/2/13 15:08 xuyuanye Exp $$
 */
public class FutureTaskTest {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(1,1,60, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));
        Future<String> resultFuture = executorService.submit(new Callable<String>() {
            /**
             * Computes a result, or throws an exception if unable to do so.
             *
             * @return computed result
             * @throws Exception if unable to compute a result
             */
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(20);
                return "FutureTaskTest";
            }
        });
        try {
            String result = resultFuture.get();
            System.out.println(result);
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
