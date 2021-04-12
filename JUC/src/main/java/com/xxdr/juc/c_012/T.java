package com.xxdr.juc.c_012;

import java.util.concurrent.TimeUnit;

/**
 * @Author John Yuan
 * @Description volatile 1. 保证线程可见性（实现：MESI，缓存一致性协议） 2. 禁止指令重排序
 * @Date 2021/4/11 11:30
 * @Version 1.0
 */
public class T {
    boolean running = true;
    void m() {
        System.out.println("m start");
        while (running) {

        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false;
    }
}
