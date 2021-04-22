package com.xxdr.juc.c_025;

import com.xxdr.juc.c_001.T;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/21 23:27
 * @Version 1.0
 */
public class T02_CopyOnWriteList {
    public static void main(String[] args) {
        List<String> lists = new CopyOnWriteArrayList<>();
        Random r = new Random();
        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        lists.add("a" + r.nextInt(10000));
                    }
                }
            };
            threads[i] = new Thread(task);
        }
        runAndComputerTime(threads);
        System.out.println(lists.size());
    }

    static void runAndComputerTime(Thread[] threads) {
        long start = System.currentTimeMillis();
        Arrays.asList(threads).forEach(t -> t.start());
        Arrays.asList(threads).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
