package com.xxdr.juc.c_000;

/**
 * @ClassName T02_HowToCreateThread
 * @Description TODO
 * @Author John Yuan
 * @Date 4/9/21 2:01 PM
 * @Version 1.0
 */
public class T02_HowToCreateThread {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(()-> System.out.println("Hello lambda!")).start();
    }
}
