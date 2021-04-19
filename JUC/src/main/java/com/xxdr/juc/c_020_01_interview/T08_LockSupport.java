package com.xxdr.juc.c_020_01_interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/18 16:00
 * @Version 1.0
 */
public class T08_LockSupport {
    volatile List lists = new ArrayList();
    static Thread t1 = null, t2 = null;

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        T08_LockSupport c = new T08_LockSupport();

        t2 = new Thread(() -> {
            System.out.println("t2 start");
            LockSupport.park();
            System.out.println("t2 end");
            LockSupport.unpark(t1);
        }, "t2");

        t1 = new Thread(() -> {
            System.out.println("t1 start");
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add " + i);

                if (c.size() == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }, "t1");

        t2.start();
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        t1.start();
    }
}
