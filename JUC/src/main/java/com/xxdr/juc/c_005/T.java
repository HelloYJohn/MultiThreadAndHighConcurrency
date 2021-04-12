package com.xxdr.juc.c_005;

/**
 * @Author John Yuan
 * @Description 加了synchronized没有必要再加volatile，因为
 * synchronized既保证原子性，又保证可见性
 * @Date 2021/4/10 11:32
 * @Version 1.0
 */
public class T implements Runnable{
    private int count = 100;
    public void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        T t = new T();
        for (int i = 0; i < 100; i++) {
            new Thread(t, "Thread" + i).start();
        }
    }
}
