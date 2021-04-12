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
        // testSleep();
        // testYield();
        testJoin();
    }

    /**
     * Sleep 意思是睡眠，当前线程暂停一段时间让给别的线程去运行
     */
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

    /**
     * Yield，就是当前线程正在执行的时候停止下来进入等待队列，回到等待队列里在系统的调度算法里头还是有可能把你刚回去的线程拿回来继续执行，当然
     * 更大可能性是把原来等待的那些拿出来一个来执行
     */
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

    /**
     * 在自己当前线程加入你调用的Join线程，本线程等待。等调用的线程运行完了，自己再去执行
     */
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

        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++) {
                System.out.println("B" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
