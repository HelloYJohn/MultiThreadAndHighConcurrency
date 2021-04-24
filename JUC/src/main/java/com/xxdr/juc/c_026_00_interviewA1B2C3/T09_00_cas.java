package com.xxdr.juc.c_026_00_interviewA1B2C3;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/24 10:39
 * @Version 1.0
 */
public class T09_00_cas {
    enum ReadyToRun {T1, T2};

    static volatile ReadyToRun r = ReadyToRun.T1;

    public static void main(String[] args) {
        char[] numberChar = "1234567".toCharArray();
        char[] letterChar = "ABCDEFG".toCharArray();

        new Thread(() -> {
            for (char c : letterChar) {
                while (r != ReadyToRun.T1) {}
                System.out.print(c);
                r = ReadyToRun.T2;
            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : numberChar) {
                while (r != ReadyToRun.T2) {}
                System.out.print(c);
                r = ReadyToRun.T1;
            }
        }, "t2").start();

    }
}
