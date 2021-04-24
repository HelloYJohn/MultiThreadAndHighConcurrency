package com.xxdr.juc.c_026_00_interviewA1B2C3;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/23 21:58
 * @Version 1.0
 */
public class T04_00_sync_wait_notify {
    private static volatile boolean t2Start = false;

    public static void main(String[] args) {
        final Object o = new Object();
        char[] numberChar = "1234567".toCharArray();
        char[] letterChar = "ABCDEFG".toCharArray();

        new Thread(() -> {
            synchronized (o) {
                while (!t2Start) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (char c : numberChar) {
                    System.out.print(c);
                    o.notifyAll();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notifyAll();
            }
        }).start();

//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new Thread(() -> {
            synchronized (o) {
                for (char c : letterChar) {
                    t2Start = true;
                    System.out.print(c);
                    o.notifyAll();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notifyAll();
            }
        }).start();
    }
}
