package com.xxdr.juc.c_025;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/21 22:57
 * @Version 1.0
 */
public class T01_ConcurrentMap {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        Random r = new Random();
        Thread[] threads = new Thread[100];

        CountDownLatch latch = new CountDownLatch(threads.length);
        long start = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    map.put("a" + r.nextInt(1000000), "a"+r.nextInt(1000000));
                    latch.countDown();
                }
            });
        }
        Arrays.asList(threads).forEach(t -> t.start());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(map.size());
    }
}
