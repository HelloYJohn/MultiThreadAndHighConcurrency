package com.xxdr.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author John Yuan
 * @Description 1. LockSupport不需要Synchoronized加锁可以实现线程的阻塞和唤醒
 *              2. LockSupport.unpark() 可以先于LockSupport.park()执行，并且线程不会阻塞
 *              3. 如果一个线程处于等待状态，连续调用两次park()，会使线程用于无法被唤醒
 * @Date 2021/4/18 13:41
 * @Version 1.0
 */
public class T13_TestLockSupport {
    public static void main(String[] args) {
        Thread t = new Thread(() ->  {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 5) {
                    LockSupport.park();
                }
                if (i == 8) {
                    LockSupport.park();
                }
            }
        });
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.start();
        LockSupport.unpark(t);
    }
}
