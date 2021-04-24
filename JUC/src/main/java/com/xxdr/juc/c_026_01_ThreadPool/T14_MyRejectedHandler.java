package com.xxdr.juc.c_026_01_ThreadPool;

import java.util.concurrent.*;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/24 22:27
 * @Version 1.0
 */
public class T14_MyRejectedHandler {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(4, 4,
                0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(6),
                Executors.defaultThreadFactory(),
                new MyHandler());
    }

    static class MyHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            if (executor.getQueue().size() < 10000) {

            }
        }
    }
}
