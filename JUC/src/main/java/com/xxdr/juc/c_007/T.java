package com.xxdr.juc.c_007;

/**
 * @Author John Yuan
 * @Description 同步方法和非同步方法可以同时调用
 * @Date 2021/4/10 11:44
 * @Version 1.0
 */
public class T {
    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end");
    }

    public void m2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 ");
    }

    public static void main(String[] args) {
        T t = new T();

        // new Thread(()->t.m1(), "t1").start();
        // new Thread(()->t.m2(), "t2").start();

        // new Thread(t::m1, "t1").start();
        // new Thread(t::m2, "t2").start();

        // jdk 1.8 before
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m1();
            }
        }, "t1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m2();
            }
        }, "t2").start();
    }
}
