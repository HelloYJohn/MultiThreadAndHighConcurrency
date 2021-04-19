package com.xxdr.juc.c_020;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName T05_ReentrantLock5
 * @Description fair lock
 * @Author John Yuan
 * @Date 4/15/21 1:50 PM
 * @Version 1.0
 */
public class T05_ReentrantLock5 extends Thread {
    private static ReentrantLock lock = new ReentrantLock(true);
    // private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " get lock");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        T05_ReentrantLock5 rl = new T05_ReentrantLock5();
        Thread th1 = new Thread(rl);
        Thread th2 = new Thread(rl);
        th1.start();
        th2.start();
    }
}
