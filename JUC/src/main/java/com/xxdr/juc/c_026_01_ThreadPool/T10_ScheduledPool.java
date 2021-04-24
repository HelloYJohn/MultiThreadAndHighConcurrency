package com.xxdr.juc.c_026_01_ThreadPool;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/24 22:20
 * @Version 1.0
 */
public class T10_ScheduledPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }, 0, 500, TimeUnit.MILLISECONDS);
    }
}
