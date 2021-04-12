package com.xxdr.juc.c_004;

/**
 * @Author John Yuan
 * @Description 静态方法中没有this对象，在方法上加synchronized意味着synchronized(T.class)
 * @Date 2021/4/10 11:23
 * @Version 1.0
 */

public class T {
    private static int count = 10;

    /**
     * lock an object
     */
    public synchronized static void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    /**
     * If it's the same ClassLoad, T.class is a Singleton
     */
    public static void mm() {
        synchronized (T.class) {
            count--;
        }
    }
}
