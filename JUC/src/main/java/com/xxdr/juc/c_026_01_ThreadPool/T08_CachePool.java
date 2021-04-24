package com.xxdr.juc.c_026_01_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/24 21:50
 * @Version 1.0
 */
public class T08_CachePool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println(executorService);
        for (int i = 0; i < 2; i++) {
            executorService.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println(executorService);
        try {
            TimeUnit.SECONDS.sleep(80);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(executorService);
    }
}
