package com.xyy.reference;

import com.xyy.Demo;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author XYY
 * @version Id: ReferenceTest.java, v 0.1 2018/11/13 21:32 xuyuanye Exp $$
 */
public class ReferenceTest {
    public static void main(String[] args) {
        Demo demo = new Demo("demo");
        ReferenceQueue rq = new ReferenceQueue();
        WeakReference<Demo> weakReferenceDemo = new WeakReference<Demo>(demo,rq);
        int i=0;
        while(true){
            if(weakReferenceDemo.get()!=null){
                i++;
                System.out.println("Object is alive for "+i+" loops - "+weakReferenceDemo);
            }else{
                System.out.println("Object has been collected.");
                Reference d = rq.poll();
                System.out.println("Reference"+d );
                break;
            }
        }
        //在上例中, 程序运行一段时间后, 程序打印出"Object has been collected." 说明, weak reference指向的对象的被回收了.

    }
}

