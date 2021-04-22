package com.xxdr.juc.c_025;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/21 23:36
 * @Version 1.0
 */
public class T04_ConcurrentQueue {
    public static void main(String[] args) {
        Queue<String> stringQueue = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < 10; i++) {
            stringQueue.offer("a" + i);
        }

        System.out.println(stringQueue);

        System.out.println(stringQueue.size());

        System.out.println(stringQueue.poll());
        System.out.println(stringQueue.size());

        System.out.println(stringQueue.peek());
        System.out.println(stringQueue.size());

    }
}
