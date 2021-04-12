package com.xxdr.juc.c_000;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName WhatIsThread
 * @Description 线程可以简单说是一个程序里不同的执行路径
 * @Author John Yuan
 * @Date 4/9/21 1:52 PM
 * @Version 1.0
 */
public class T01_WhatIsThread {
    private static class T1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i <10; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }

    public static void main(String[] args) {
        new T1().start();
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main");
        }
    }
}
