/**
 * This file is part of the SingletonThreadPool library
 * Copyright (C) 2014 zhangshuang
 *
 * for more please visit http://twitness.github.io
 */
package org.alvin.singletonquepool.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 公共使用方法，该类实现了一个通用的线程池
 *
 * @author zhangshuang
 * @version 1.0
 */
@SuppressWarnings("UnusedDeclaration")
public class SingletonThreadPool {

    /**
     * 单例模式的线程池，运行中只允许一个该线程池的实例存在
     */
    private static final AtomicReference<SingletonThreadPool> instance = new AtomicReference<SingletonThreadPool>();

    private static int maxSize = 50;

    private static int coreSize = 0;

    private static int keepAliveTime = 1;

    private static TimeUnit timeUnit = TimeUnit.MINUTES;

    private static int threadPoolWaitingQueueSize = 20;

    private ThreadPoolExecutor pool = null;

    /**
     * 单例模式 程序中只能实例化一次该对象，调用应使用getInstance方法
     *
     * @throws SingletonThreadPoolException
     */
    private SingletonThreadPool(int coreSize, int maxSize, int keepAliveTime, TimeUnit timeUnit, int threadPoolWaitingQueueSize)
            throws SingletonThreadPoolException {

        SingletonThreadPool.maxSize = maxSize;
        SingletonThreadPool.coreSize = coreSize;
        SingletonThreadPool.keepAliveTime = keepAliveTime;
        SingletonThreadPool.timeUnit = timeUnit;
        SingletonThreadPool.threadPoolWaitingQueueSize = threadPoolWaitingQueueSize;

        if (coreSize < 0) throw new SingletonThreadPoolException(" because coreSizw is less than 0");

        if (maxSize <= 0) throw new SingletonThreadPoolException(" because maxSize is not more than 0");

        if (maxSize < coreSize)
            throw new SingletonThreadPoolException(" because maxSize is less than coresize: maxSize=" + maxSize + ", coreSize=" + coreSize);

        if (keepAliveTime < 0) throw new SingletonThreadPoolException(" because keepAliveSize is less than 0");

        pool = new ThreadPoolExecutor(
                SingletonThreadPool.coreSize, // 核心线程大小，当只有一个线程在池中时也会初始换该大小的线程池，并且只有该线程处于活动状态，其他线程处于空闲状态
                SingletonThreadPool.maxSize, // 扩展后最大线程数。
                SingletonThreadPool.keepAliveTime, // 超过1分钟没有活动的线程可以被回收
                SingletonThreadPool.timeUnit, // 超时单位分钟
                new LinkedBlockingDeque<Runnable>(SingletonThreadPool.threadPoolWaitingQueueSize), // 有界队列，保存等待执行的任务
                new ThreadPoolExecutor.CallerRunsPolicy()); // 有界队列被填满后，线程池使用的饱和策略

    }

    public static SingletonThreadPool getInstance(int coreSize, int maxSize, int keepAliveTime, TimeUnit timeUnit, int threadPoolWaitingQueueSize)
            throws SingletonThreadPoolException {
        if (instance.get() == null) {
            instance.compareAndSet(null, new SingletonThreadPool(coreSize, maxSize, keepAliveTime, timeUnit, threadPoolWaitingQueueSize));
        }
        return instance.get();
    }

    public static SingletonThreadPool getInstance() throws SingletonThreadPoolException {
        if (instance.get() == null) {
            instance.compareAndSet(null, new SingletonThreadPool(coreSize, maxSize, keepAliveTime, timeUnit, threadPoolWaitingQueueSize));
        }
        return instance.get();
    }

    public void execute(Runnable r) throws SingletonThreadPoolException {
        if (pool == null)
            throw new SingletonThreadPoolException("Load SingletonThreadPoolException Error: pool is empty when execute runnable");

        if (r == null) throw new SingletonThreadPoolException("Load Runnable Error: Runnable is empty.");

        pool.execute(r);
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return pool;
    }

}
