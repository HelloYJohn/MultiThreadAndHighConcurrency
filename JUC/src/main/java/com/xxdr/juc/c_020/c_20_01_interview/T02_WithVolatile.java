package com.xxdr.juc.c_020.c_20_01_interview;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author John Yuan
 * @Description volatile修饰引用类型，这个引用类型执行的另一个new出来的对象，
 * 如果这个对象中的成员发生了变化，是无法观测到的.
 * volatile 一定尽量去修饰普通的值，不要去修饰引用类型
 * @Date 2021/4/18 14:58
 * @Version 1.0
 */
public class T02_WithVolatile {
    volatile List lists = new LinkedList();

        public void add(Object o) {
            lists.add(o);
        }

        public int size() {
            return lists.size();
        }

        public static void main(String[] args) {
            T02_WithVolatile c = new T02_WithVolatile();
            new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    c.add(new Object());
                    System.out.println("add " + i);
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }, "t1").start();

            new Thread(() -> {
                while (true) {
                    if (c.size() == 5) {
                        break;
                    }
                }
                System.out.println("t2 end");
            }, "t2").start();
    }
}
