package com.xxdr.juc.c_000;

/**
 * @Author John Yuan
 * @Description 线程有六种状态 New Runnable(Ready Running) TimeoutWaiting Waiting Blocked Terminated
 * @Date 2021/4/10 10:58
 * @Version 1.0
 */
public class T04_ThreadState{
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(this.getState());

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(i);
            }
        }
    }


    public static void main(String[] args) {
        Thread t = new MyThread();

        System.out.println(t.getState());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getState());
    }
}
