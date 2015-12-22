package org.alvin.singletonquepool.queue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by zhangshuang on 15/11/19.
 */
@SuppressWarnings("UnusedDeclaration")
public class SingletonLinkedBlockingQueue {

    private static final AtomicReference<SingletonLinkedBlockingQueue> instance = new AtomicReference<SingletonLinkedBlockingQueue>();

    private LinkedBlockingQueue<QElement> queue = null;

    private static int capacity = 50;

    private SingletonLinkedBlockingQueue(int capacity) {
        SingletonLinkedBlockingQueue.capacity = capacity;
        this.queue = new LinkedBlockingQueue<QElement>(capacity);
    }

    public static SingletonLinkedBlockingQueue getInstance() {
        if (instance.get() == null) {
            instance.compareAndSet(null, new SingletonLinkedBlockingQueue(SingletonLinkedBlockingQueue.capacity));
        }
        return instance.get();
    }

    public static SingletonLinkedBlockingQueue getInstance(int capacity) {
        if (instance.get() == null) {
            instance.compareAndSet(null, new SingletonLinkedBlockingQueue(capacity));
        }
        return instance.get();
    }

    public QElement take() throws InterruptedException {
        return queue.take();
    }

    public void put(QElement qElement) throws InterruptedException {
        queue.put(qElement);
    }

    public int size() {
        return queue.size();
    }




}
