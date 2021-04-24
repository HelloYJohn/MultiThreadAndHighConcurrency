package com.xxdr.juc.c_026_01_ThreadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/24 13:03
 * @Version 1.0
 */
public class T06_00_Future {
    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        });

        new Thread(task).start();

        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
