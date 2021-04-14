package com.xxdr.juc.c_017;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T
 * @Description Lock an object o, if the properties of the object change,
 * it does not affect the use of the lock. If o becomes another object,
 * the locked object changes. Avoid changing the reference of the locked
 * object into another object.
 * @Author John Yuan
 * @Date 4/13/21 10:52 AM
 * @Version 1.0
 */
public class T {
    /* final */ Object o = new Object();

    void m() {
        synchronized (o) {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(t::m, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(t::m, "t2");
        t.o = new Object();
        t2.start();

    }
}
