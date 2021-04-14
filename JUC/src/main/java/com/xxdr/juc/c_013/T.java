package com.xxdr.juc.c_013;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName T
 * @Description volatile can't replace synchronized because volatile is not Atomic
 * @Author John Yuan
 * @Date 4/13/21 9:31 AM
 * @Version 1.0
 */
public class T {
    volatile int count = 0;

    void m() {
        for (int i = 0; i < 10000; i++) {
            synchronized (this) {
                count++;
            }
        }
    }

    public static void main(String[] args) {
        T t = new T();
        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }

        threads.forEach((o)-> o.start());

        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
    }
}
