package com.xxdr.juc.c_020;

import java.util.concurrent.Semaphore;

/**
 * @Author John Yuan
 * @Description Semaphore and fair
 * @Date 2021/4/18 12:08
 * @Version 1.0
 */
public class T11_TestSemaphore {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Semaphore s = new Semaphore(2);
//        Semaphore s = new Semaphore(2, true);
        Thread t1 = new Thread(() -> {
            try {
                s.acquire();
                System.out.println("T1 running...");
                Thread.sleep(200);
                System.out.println("T1 running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                s.acquire();
                System.out.println("T2 running...");
                Thread.sleep(200);
                System.out.println("T2 running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
