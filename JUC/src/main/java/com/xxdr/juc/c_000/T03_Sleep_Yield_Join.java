package com.xxdr.juc.c_000;

/**
 * @ClassName T03_Sleep_Yield_Join
 * @Description TODO
 * @Author John Yuan
 * @Date 4/9/21 2:04 PM
 * @Version 1.0
 */
public class T03_Sleep_Yield_Join {
    public static void main(String[] args) {
        testSleep();
        testYield();
        testJoin();
    }

    static void testSleep() {
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static void testYield() {
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                if (i%10 == 0)
                    Thread.yield();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("--------B" + i);
                if (i%10 == 0)
                    Thread.yield();
            }
        }).start();
    }

    static void testJoin() {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread T2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
