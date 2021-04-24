package com.xxdr.juc.c_026_00_interviewA1B2C3;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/24 10:59
 * @Version 1.0
 */
public class T12_00_TransferQueue {

    public static void main(String[] args) {
        char[] numberChar = "1234567".toCharArray();
        char[] letterChar = "ABCDEFG".toCharArray();

        TransferQueue<Character> queue = new LinkedTransferQueue<>();
        new Thread(() -> {
            try {
                for (char c : numberChar) {
                    System.out.print(queue.take());
                    queue.transfer(c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                for (char c : letterChar) {
                    queue.transfer(c);
                    System.out.print(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();

    }
}
