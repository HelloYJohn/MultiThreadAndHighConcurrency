package com.xxdr.juc;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadLocal2
 * @Description TODO
 * @Author John Yuan
 * @Date 4/21/21 6:04 PM
 * @Version 1.0
 */
public class ThreadLocal2{
    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person());
        }).start();
    }
}


