package com.xyy;

import java.util.concurrent.Semaphore;

/**
 * @author XYY
 * @version Id: SemaphoreSynchronousQueue.java, v 0.1 2018/11/20 15:05 xuyuanye Exp $$
 */
public class SemaphoreSynchronousQueue<E> {
    E item = null;
    //Semaphore sync = new Semaphore(0);
    Semaphore send = new Semaphore(1);
    Semaphore recv = new Semaphore(0);

    public E take() throws InterruptedException {
        recv.acquire();
        E x = item;
        //sync.release();
        send.release();
        return x;
    }

    public void put (E x) throws InterruptedException{
        send.acquire();
        item = x;
        recv.release();
        //sync.acquire();
    }

}

