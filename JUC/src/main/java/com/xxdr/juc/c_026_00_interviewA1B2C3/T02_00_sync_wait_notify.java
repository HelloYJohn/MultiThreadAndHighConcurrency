package com.xxdr.juc.c_026_00_interviewA1B2C3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName T02_00_sync_wait_notify
 * @Description TODO
 * @Author John Yuan
 * @Date 4/23/21 5:29 PM
 * @Version 1.0
 */
public class T02_00_sync_wait_notify {
    public static void main(String[] args) {
        final Object o = new Object();
        char[] numberChar = "1234567".toCharArray();
        char[] letterChar = "ABCDEFG".toCharArray();

        new Thread(() -> {
            synchronized (o) {
                for (char c : numberChar) {
                    System.out.print(c);
                    o.notifyAll();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notifyAll();
            }
        }).start();

//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new Thread(() -> {
            synchronized (o) {
                for (char c : letterChar) {
                    System.out.print(c);
                    o.notifyAll();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notifyAll();
            }
        }).start();
    }
}
