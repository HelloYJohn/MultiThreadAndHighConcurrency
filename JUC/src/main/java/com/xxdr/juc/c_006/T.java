package com.xxdr.juc.c_006;

/**
 * @Author John Yuan
 * @Description T中count在每个线程都是一个不同的T对象，结果必然都是9
 * @Date 2021/4/10 12:02
 * @Version 1.0
 */
public class T implements Runnable {
    private int count = 10;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            T t = new T();
            new Thread(t, "THREAD" + i).start();
        }
    }
}
