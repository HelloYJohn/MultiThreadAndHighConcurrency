package com.xxdr.juc.c_021_AQS;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestReentrantLock
 * @Description TODO
 * @Author John Yuan
 * @Date 4/21/21 2:30 PM
 * @Version 1.0
 */
public class TestReentrantLock {
    private static volatile int i = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {
            lock.lock();
            i--;
            Scanner scanner = new Scanner(System.in);
            scanner.next();
            lock.unlock();
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        i++;
        lock.unlock();
    }
}
