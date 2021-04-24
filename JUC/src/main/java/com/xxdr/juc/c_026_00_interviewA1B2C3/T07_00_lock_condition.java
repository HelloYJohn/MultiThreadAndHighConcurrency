package com.xxdr.juc.c_026_00_interviewA1B2C3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/23 22:16
 * @Version 1.0
 */
public class T07_00_lock_condition {


    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(1);
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        char[] numberChar = "1234567".toCharArray();
        char[] letterChar = "ABCDEFG".toCharArray();


        new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                lock.lock();
                for (char c : numberChar) {
                    System.out.print(c);
                    condition2.signal();
                    try {
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                condition2.signal();
            } finally {
                lock.unlock();
            }
        }, "t1").start();

//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new Thread(() -> {
            latch.countDown();
            try {
                lock.lock();
                for (char c : letterChar) {
                    System.out.print(c);
                    condition1.signal();
                    try {
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                condition1.signal();
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }
}
