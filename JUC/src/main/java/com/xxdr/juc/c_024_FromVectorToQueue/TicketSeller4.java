package com.xxdr.juc.c_024_FromVectorToQueue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/21 22:48
 * @Version 1.0
 */
public class TicketSeller4 {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    static Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("ticket id " + i);
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i <10; i++) {
            threads[i] = new Thread(() -> {
                while (true) {
                    String s = tickets.poll();
                    if (s == null) break;
                    else {
                        atomicInteger.getAndAdd(1);
                        System.out.println("sell --" + s);
                    }
                }
            });
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(atomicInteger.get());
    }
}
