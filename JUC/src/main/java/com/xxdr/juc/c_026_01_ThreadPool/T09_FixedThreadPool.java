package com.xxdr.juc.c_026_01_ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/24 21:57
 * @Version 1.0
 */
public class T09_FixedThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println(getPrime(1, 200000).size());
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        final int cpuCoreNum = 4;

        ExecutorService executorService = Executors.newFixedThreadPool(cpuCoreNum);

        MyTask t1 = new MyTask(1, 80000);
        MyTask t2 = new MyTask(80001, 130000);
        MyTask t3 = new MyTask(130001, 170000);
        MyTask t4 = new MyTask(170001, 200000);

        Future<List<Integer>> f1 = executorService.submit(t1);
        Future<List<Integer>> f2 = executorService.submit(t2);
        Future<List<Integer>> f3 = executorService.submit(t3);
        Future<List<Integer>> f4 = executorService.submit(t4);

        start = System.currentTimeMillis();
        System.out.println(f1.get().size());
        System.out.println(f2.get().size());
        System.out.println(f3.get().size());
        System.out.println(f4.get().size());
        end = System.currentTimeMillis();
        System.out.println(end - start);
        executorService.shutdown();
    }

    static class MyTask implements Callable<List<Integer>> {
        int startPos, endPos;

        public MyTask(int startPos, int endPos) {
            this.startPos = startPos;
            this.endPos = endPos;
        }

        @Override
        public List<Integer> call() throws Exception {
            List<Integer> r = getPrime(startPos, endPos);
            return r;
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    static List<Integer> getPrime(int start, int end) {
        List<Integer> results = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if(isPrime(i)) results.add(i);
        }
        return results;
    }
}
