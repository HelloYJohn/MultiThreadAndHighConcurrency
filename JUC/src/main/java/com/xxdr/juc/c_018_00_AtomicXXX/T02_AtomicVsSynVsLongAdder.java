package com.xxdr.juc.c_018_00_AtomicXXX;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @ClassName T02_AtomicVsSynVsLongAdder
 * @Description TODO
 * @Author John Yuan
 * @Date 4/13/21 5:40 PM
 * @Version 1.0
 */
public class T02_AtomicVsSynVsLongAdder {
    static AtomicLong count1 = new AtomicLong(0L);
    static long count2 = 0;
    static LongAdder count3 = new LongAdder();

    public static void main(String[] args) {
        Thread[] threads = new Thread[1000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 100000; j++) {
                    count1.incrementAndGet();
                }
            });
        }
        long start = System.currentTimeMillis();
        for(Thread t : threads) t.start();
        for(Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Atomic: " + count1.get() + " time " + (end-start));

        Object lock = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100000; j++) {
                        synchronized (lock) {
                            count2++;
                        }
                    }
                }
            });
        }

        start = System.currentTimeMillis();
        for(Thread t : threads) t.start();
        for(Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Sync: " + count2 + " time " + (end-start));

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 100000; j++) {
                    count3.increment();
                }
            });
        }

        start = System.currentTimeMillis();
        for(Thread t : threads) t.start();
        for(Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        end = System.currentTimeMillis();
        System.out.println("LongAdder: " + count3.longValue() + " time " + (end-start));
    }
}
