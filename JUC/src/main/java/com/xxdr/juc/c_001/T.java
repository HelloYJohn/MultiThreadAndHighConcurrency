package com.xxdr.juc.c_001;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/10 11:07
 * @Version 1.0
 */
public class T {
    private int count = 10;
    private Object o = new Object();

    /**
     * lock an object
     */
    public void m() {
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}
