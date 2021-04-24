package com.xxdr.juc.c_026_01_ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/24 22:25
 * @Version 1.0
 */
public class T07_SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            executorService.execute(() -> {
                System.out.println(j + " " + Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }
}
