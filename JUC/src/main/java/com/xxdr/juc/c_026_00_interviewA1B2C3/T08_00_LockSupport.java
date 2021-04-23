package com.xxdr.juc.c_026_00_interviewA1B2C3;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName T08_00_LockSupport
 * @Description TODO
 * @Author John Yuan
 * @Date 4/23/21 5:26 PM
 * @Version 1.0
 */
public class T08_00_LockSupport {
    private static Thread t1, t2;
    public static void main(String[] args) {
        char[] numberChar = "1234567".toCharArray();
        char[] letterChar = "ABCDEFG".toCharArray();

        t1 = new Thread(() -> {
            for (char c : letterChar) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });

        t2 = new Thread(() -> {
            for (char c : numberChar) {
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();
    }
}
