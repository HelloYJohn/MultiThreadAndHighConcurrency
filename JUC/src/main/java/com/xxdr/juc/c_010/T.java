package com.xxdr.juc.c_010;

import java.util.concurrent.TimeUnit;

/**
 * @Author John Yuan
 * @Description 父子类的可重入，锁的是同一个对象
 * @Date 2021/4/10 16:27
 * @Version 1.0
 */
public class T {
    synchronized void m() {
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new TT().m();
    }
}

class TT extends T {
    @Override
    synchronized void m() {
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");
    }
}
