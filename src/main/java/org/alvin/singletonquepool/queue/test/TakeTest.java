package org.alvin.singletonquepool.queue.test;


import org.alvin.singletonquepool.queue.SingletonLinkedBlockingQueue;

/**
 * Created by zhangshuang on 15/11/19.
 */
public class TakeTest implements Runnable {
    @Override
    public void run() {
        SingletonLinkedBlockingQueue queue = SingletonLinkedBlockingQueue.getInstance();
        Test element = null;
        do {
            try {
                element = (Test) queue.take();
                System.out.println("take:" + element.getNumber());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (element != null && element.getNumber() >= 0);
    }
}
