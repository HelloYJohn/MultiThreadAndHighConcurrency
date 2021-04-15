package com.xxdr.juc.c_020;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName T07_TestCyclicBarrier
 * @Description TODO
 * @Author John Yuan
 * @Date 4/15/21 5:27 PM
 * @Version 1.0
 */
public class T07_TestCyclicBarrier {
    public static void main(String[] args) {

        // CyclicBarrier barrier = new CyclicBarrier(20);

        CyclicBarrier barrier = new CyclicBarrier(20, () -> System.out.println("ok, start"));

//        CyclicBarrier barrier = new CyclicBarrier(20, new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("ok, start");
//            }
//        });
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
