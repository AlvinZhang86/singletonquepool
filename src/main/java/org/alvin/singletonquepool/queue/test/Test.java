package org.alvin.singletonquepool.queue.test;


import org.alvin.singletonquepool.queue.QElement;
import org.alvin.singletonquepool.threadpool.SingletonThreadPool;
import org.alvin.singletonquepool.threadpool.SingletonThreadPoolException;

/**
 * Created by zhangshuang on 15/11/19.
 */
public class Test extends QElement {
    private int number = 0;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public static void main(String[] args) throws SingletonThreadPoolException {
        SingletonThreadPool pool = SingletonThreadPool.getInstance();


        PutTest pt = new PutTest();
        Thread thread = new Thread(pt);
        thread.start();


        TakeTest tt = new TakeTest();
        Thread thread1 = new Thread(tt);
        thread1.start();



    }
}
