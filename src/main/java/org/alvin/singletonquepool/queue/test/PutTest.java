package org.alvin.singletonquepool.queue.test;


import org.alvin.singletonquepool.queue.SingletonLinkedBlockingQueue;

/**
 * Created by zhangshuang on 15/11/19.
 */
public class PutTest implements Runnable {


    @Override
    public void run() {
        SingletonLinkedBlockingQueue queue = SingletonLinkedBlockingQueue.getInstance();
        for (int i = 0 ; i< 1000; i ++) {
            Test element = new Test();
            element.setNumber(i);
            try {
                queue.put(element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("put:" + element.getNumber());
        }

        Test testend = new Test();
        testend.setNumber(-1);
        try {
            queue.put(testend);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
