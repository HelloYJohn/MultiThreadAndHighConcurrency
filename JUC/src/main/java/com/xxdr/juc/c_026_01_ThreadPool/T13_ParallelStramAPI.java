package com.xxdr.juc.c_026_01_ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/24 23:07
 * @Version 1.0
 */
public class T13_ParallelStramAPI {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            nums.add(1000000 + r.nextInt(1000000));
        }

        long start = System.currentTimeMillis();
        nums.forEach(v -> isPrime(v));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        nums.parallelStream().forEach(T13_ParallelStramAPI::isPrime);
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    static boolean isPrime(int num) {
        for (int i = 2; i < num/2; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
