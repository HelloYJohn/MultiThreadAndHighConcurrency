package com.xxdr.juc.c_020.c_20_01_interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/18 16:12
 * @Version 1.0
 */
public class T09_Semaphore {
    volatile List lists = new ArrayList();
    static Thread t1 = null, t2 = null;

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        T09_Semaphore c = new T09_Semaphore();
        Semaphore s = new Semaphore(1);

        t2 = new Thread(() -> {
            try {
                s.acquire();
                System.out.println("t2 start");
                System.out.println("t2 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }

        }, "t2");

        t1 = new Thread(() -> {
            System.out.println("t1 start");
            try {
                s.acquire();
                for (int i = 0; i < 5; i++) {
                    c.add(new Object());
                    System.out.println("add " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
            try {
                t2.start();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                s.acquire();
                for (int i = 5; i < 10; i++) {
                    c.add(new Object());
                    System.out.println("add " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }

        }, "t1");
        // t2.start();
        t1.start();
    }
}
