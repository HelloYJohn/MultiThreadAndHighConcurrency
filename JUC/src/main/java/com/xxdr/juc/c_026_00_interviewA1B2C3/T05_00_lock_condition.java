package com.xxdr.juc.c_026_00_interviewA1B2C3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/23 22:06
 * @Version 1.0
 */
public class T05_00_lock_condition {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        char[] numberChar = "1234567".toCharArray();
        char[] letterChar = "ABCDEFG".toCharArray();


        new Thread(() -> {
            try {
                lock.lock();
                for (char c : numberChar) {
                    System.out.print(c);
                    condition.signal();
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                condition.signal();
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
            try {
                lock.lock();
                for (char c : letterChar) {
                    System.out.print(c);
                    condition.signal();
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                condition.signal();
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }
}
