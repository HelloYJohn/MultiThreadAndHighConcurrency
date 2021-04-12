package com.xxdr.juc.c_003;

/**
 * @Author John Yuan
 * @Description 方法前有synchronized意味着synchronized(this)包裹方法中所有的语句
 * @Date 2021/4/10 11:21
 * @Version 1.0
 */
public class T {
    private int count = 10;

    /**
     * lock an object
     */
    public synchronized void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}
