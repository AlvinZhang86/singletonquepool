package org.alvin.singletonquepool.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by zhangshuang on 15/11/23.
 */
@SuppressWarnings("UnusedDeclaration")
public class SingletonThreadPoolGroup {

    private static final AtomicReference<SingletonThreadPoolGroup> instance = new AtomicReference<SingletonThreadPoolGroup>();

    private static int size = 3;

    private ThreadPoolExecutor[] singletonThreadPoolGroup;

    private SingletonThreadPoolGroup(int size) {
        SingletonThreadPoolGroup.size = size;
        singletonThreadPoolGroup = new ThreadPoolExecutor[size];

        for (int i = 0; i < size; i++) {
            SingletonThreadPoolBean bean = new SingletonThreadPoolBean();
            singletonThreadPoolGroup[i] = new ThreadPoolExecutor(
                    bean.getCoreSize(),
                    bean.getMaxSize(),
                    bean.getKeepAliveTime(),
                    bean.getUnit(),
                    new LinkedBlockingDeque<Runnable>(bean.getThreadPoolWaitingQueueSize()),
                    bean.getHandler());
        }
    }

    public static SingletonThreadPoolGroup getInstance(int size) {
        if (instance.get() == null) {
            instance.compareAndSet(null, new SingletonThreadPoolGroup(size));
        }
        return instance.get();
    }

    public static SingletonThreadPoolGroup getInstance() {
        if (instance.get() == null) {
            instance.compareAndSet(null, new SingletonThreadPoolGroup(size));
        }
        return instance.get();
    }

    public int getSize() {
        return size;
    }

    public ThreadPoolExecutor getThreadPool(int index) {
        if (index > 0 && index < size) {
            return singletonThreadPoolGroup[index];
        } else {
            return null;
        }
    }

}
