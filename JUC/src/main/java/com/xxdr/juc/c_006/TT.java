package com.xxdr.juc.c_006;

/**
 * @Author John Yuan
 * @Description TT中的count和MyRunnable没有关系，则无论MyRunnable在不同线程中是否是一个对象，没有影响
 * @Date 2021/4/10 15:26
 * @Version 1.0
 */
public class TT {
    private static int count = 10;
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            synchronized(TT.class) {
                count--;
                System.out.println(Thread.currentThread().getName() + " count = " + count);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MyRunnable myRunnable = new MyRunnable();
            new Thread(myRunnable, "THREAD" + i).start();
        }
    }
}
