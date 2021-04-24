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
    private static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        char[] numberChar = "1234567".toCharArray();
        char[] letterChar = "ABCDEFG".toCharArray();

        t1 = new Thread(() -> {
            for (char c : letterChar) {
                System.out.print(c);
                LockSupport.unpark(t2);   // 叫醒t2
                LockSupport.park();    // t1阻塞
            }
        });

        t2 = new Thread(() -> {
            for (char c : numberChar) {
                LockSupport.park();   // 阻塞t2
                System.out.print(c);
                LockSupport.unpark(t1);  // 叫醒t1
            }
        });

        t1.start();
        t2.start();
    }
}
