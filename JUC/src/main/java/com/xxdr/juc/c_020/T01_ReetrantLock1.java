package com.xxdr.juc.c_020;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T01_ReetrantLock1
 * @Description Synchronization is a reentrant lock
 * @Author John Yuan
 * @Date 4/14/21 6:01 PM
 * @Version 1.0
 */
public class T01_ReetrantLock1 {
    synchronized void m1() {
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            if (i == 2) m2();
        }
    }

    synchronized void m2() {
        System.out.println("m2 ...");
    }

    public static void main(String[] args) {
        T01_ReetrantLock1 r1 = new T01_ReetrantLock1();
        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
