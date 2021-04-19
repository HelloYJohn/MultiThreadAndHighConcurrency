package com.xxdr.juc.c_020_01_interview;

import java.util.concurrent.TimeUnit;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/18 16:37
 * @Version 1.0
 */
public class T10_CrossPrintAlphabetAndNumber {

    public static void main(String[] args) {
        T04_NotifyHoldingLock c = new T04_NotifyHoldingLock();
        final Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 start");
                for (int i = 1; i <= 26; i++) {
                    try {
                        lock.wait();
                        System.out.println(i);
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 end");

            }
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("t1 start");
            synchronized (lock) {
                for (int i = 0; i < 26; i++) {
                    System.out.println((char)('a' + i));
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();
    }
}
