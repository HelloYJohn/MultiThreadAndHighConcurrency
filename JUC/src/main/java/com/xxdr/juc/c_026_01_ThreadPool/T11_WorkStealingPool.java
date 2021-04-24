package com.xxdr.juc.c_026_01_ThreadPool;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/24 22:31
 * @Version 1.0
 */
public class T11_WorkStealingPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newWorkStealingPool();
        System.out.println(Runtime.getRuntime().availableProcessors());

        executorService.execute(new R(1000));
        executorService.execute(new R(2000));
        executorService.execute(new R(2000));
        executorService.execute(new R(2000));
        executorService.execute(new R(2000));

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class R implements Runnable {
        int time;

        public R(int time) {
            this.time = time;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(time + " " + Thread.currentThread().getName());
        }
    }
}
