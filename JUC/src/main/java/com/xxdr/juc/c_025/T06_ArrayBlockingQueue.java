package com.xxdr.juc.c_025;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/21 23:43
 * @Version 1.0
 */
public class T06_ArrayBlockingQueue {
    static BlockingQueue<String> stringBlockingQueue = new ArrayBlockingQueue<>(10);

    static Random r = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            try {
                stringBlockingQueue.put("a" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            stringBlockingQueue.put("aaa");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stringBlockingQueue.add("aaa");
        stringBlockingQueue.offer("aaa");
        try {
            stringBlockingQueue.offer("aaa",1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(stringBlockingQueue);
    }
}
