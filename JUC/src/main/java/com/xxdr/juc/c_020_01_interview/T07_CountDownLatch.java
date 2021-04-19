package com.xxdr.juc.c_020_01_interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/18 15:58
 * @Version 1.0
 */
public class T07_CountDownLatch {
    volatile List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        T07_CountDownLatch c = new T07_CountDownLatch();
        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2 start");
            // if (c.size() != 5) {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // }
            System.out.println("t2 end");
            latch.countDown();
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("t1 start");
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add " + i);

                if (c.size() == 5) {
                    latch.countDown();
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
            }
        }, "t1").start();
    }
}
