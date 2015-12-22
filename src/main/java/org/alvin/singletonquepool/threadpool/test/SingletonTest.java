package org.alvin.singletonquepool.threadpool.test;


import org.alvin.singletonquepool.threadpool.SingletonThreadPoolGroup;

/**
 * Created by zhangshuang on 15/11/23.
 */
public class SingletonTest {
    public static void main(String[] args) {
        SingletonThreadPoolGroup group = SingletonThreadPoolGroup.getInstance();
        System.out.println(group.getSize());
    }
}
