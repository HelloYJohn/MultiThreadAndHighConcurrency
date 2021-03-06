package com.xxdr.juc.c_025;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author John Yuan
 * @Description 无界阻塞队列
 * @Date 2021/4/21 23:39
 * @Version 1.0
 */
public class T05_LinkedBlockingQueue {
    static BlockingQueue<String> stringBlockingQueue = new LinkedBlockingQueue<>();

    static Random r = new Random();

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    stringBlockingQueue.put("a" + i);
                    TimeUnit.MICROSECONDS.sleep(r.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "p1").start();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for(;;) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " take - " + stringBlockingQueue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "c"+i).start();
        }
    }
}
