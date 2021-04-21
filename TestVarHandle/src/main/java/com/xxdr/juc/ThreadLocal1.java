package com.xxdr.juc;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadLocal1
 * @Description TODO
 * @Author John Yuan
 * @Date 4/21/21 5:47 PM
 * @Version 1.0
 */

public class ThreadLocal1 {
    volatile static Person p = new Person();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.name);
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.name = "lisi";
        }).start();
    }
}

class Person {
    String name = "zhangsan";
}
