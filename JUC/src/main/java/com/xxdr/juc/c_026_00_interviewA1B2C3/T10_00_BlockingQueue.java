package com.xxdr.juc.c_026_00_interviewA1B2C3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/24 10:43
 * @Version 1.0
 */
public class T10_00_BlockingQueue {
    static BlockingQueue<String> q1 = new ArrayBlockingQueue<>(1);
    static BlockingQueue<String> q2 = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) {
        char[] numberChar = "1234567".toCharArray();
        char[] letterChar = "ABCDEFG".toCharArray();

        new Thread(() -> {
            for (char c : letterChar) {
                System.out.print(c);
                try {
                    q1.put("ok");
                    q2.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : numberChar) {
                try {
                    q1.take();
                    System.out.print(c);
                    q2.put("ok");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();

    }
}
