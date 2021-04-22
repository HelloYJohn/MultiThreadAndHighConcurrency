package com.xxdr.juc.c_025;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Author John Yuan
 * @Description 两个线程之间传递东西
 * @Date 2021/4/22 22:10
 * @Version 1.0
 */
public class T08_SynchronusQueue {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            blockingQueue.put("aaa");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(blockingQueue.size());
    }
}
