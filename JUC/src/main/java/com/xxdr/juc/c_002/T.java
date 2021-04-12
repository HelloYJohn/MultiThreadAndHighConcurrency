package com.xxdr.juc.c_002;

/**
 * @Author John Yuan
 * @Description synchronized关键字对某个对象加锁
 * @Date 2021/4/10 11:19
 * @Version 1.0
 */
public class T {
    private int count = 10;
    /**
     * lock an object
     */
    public void m() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}
