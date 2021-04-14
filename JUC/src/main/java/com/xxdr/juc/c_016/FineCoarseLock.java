package com.xxdr.juc.c_016;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName FineCoarseLock
 * @Description The smaller the synchronization code block, the better
 * @Author John Yuan
 * @Date 4/13/21 10:40 AM
 * @Version 1.0
 */
public class FineCoarseLock {
    int count = 0;

    synchronized void m1() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void m2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            count++;
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
