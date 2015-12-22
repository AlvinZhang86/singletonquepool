package org.alvin.singletonquepool.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangshuang on 15/11/23.
 */
@SuppressWarnings("UnusedDeclaration")
public class SingletonThreadPoolBean {
    private int coreSize;

    private int maxSize;

    private long keepAliveTime;

    private TimeUnit unit;

    private int threadPoolWaitingQueueSize;

    private RejectedExecutionHandler handler;

    public SingletonThreadPoolBean() {
        this.coreSize = 0;
        this.maxSize = 50;
        this.keepAliveTime = 1;
        this.unit = TimeUnit.MINUTES;
        this.threadPoolWaitingQueueSize = 20;
        this.handler = new ThreadPoolExecutor.CallerRunsPolicy();
    }

    public SingletonThreadPoolBean(int coreSize, int maxSize) {
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.keepAliveTime = 1;
        this.unit = TimeUnit.MINUTES;
        this.threadPoolWaitingQueueSize = 20;
        this.handler = new ThreadPoolExecutor.CallerRunsPolicy();
    }

    public SingletonThreadPoolBean(int coreSize, int maxSize, long keepAliveTime, TimeUnit unit) {
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.keepAliveTime = keepAliveTime;
        this.unit = unit;
        this.threadPoolWaitingQueueSize = 20;
        this.handler = new ThreadPoolExecutor.CallerRunsPolicy();
    }

    public SingletonThreadPoolBean(int coreSize, int maxSize, long keepAliveTime, TimeUnit unit, int threadPoolWaitingQueueSize) {
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.keepAliveTime = keepAliveTime;
        this.unit = unit;
        this.threadPoolWaitingQueueSize = threadPoolWaitingQueueSize;
        this.handler = new ThreadPoolExecutor.CallerRunsPolicy();
    }


    public int getCoreSize() {
        return coreSize;
    }

    public void setCoreSize(int coreSize) {
        this.coreSize = coreSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public TimeUnit getUnit() {
        return unit;
    }

    public void setUnit(TimeUnit unit) {
        this.unit = unit;
    }

    public int getThreadPoolWaitingQueueSize() {
        return threadPoolWaitingQueueSize;
    }

    public void setThreadPoolWaitingQueueSize(int threadPoolWaitingQueueSize) {
        this.threadPoolWaitingQueueSize = threadPoolWaitingQueueSize;
    }

    public RejectedExecutionHandler getHandler() {
        return handler;
    }

    public void setHandler(RejectedExecutionHandler handler) {
        this.handler = handler;
    }
}
