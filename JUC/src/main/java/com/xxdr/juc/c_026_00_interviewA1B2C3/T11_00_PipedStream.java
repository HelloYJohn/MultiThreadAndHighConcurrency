package com.xxdr.juc.c_026_00_interviewA1B2C3;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/24 10:46
 * @Version 1.0
 */
public class T11_00_PipedStream {

    public static void main(String[] args) {
        char[] numberChar = "1234567".toCharArray();
        char[] letterChar = "ABCDEFG".toCharArray();

        PipedInputStream inputStream1 = new PipedInputStream();
        PipedInputStream inputStream2 = new PipedInputStream();
        PipedOutputStream outputStream1 = new PipedOutputStream();
        PipedOutputStream outputStream2 = new PipedOutputStream();

        try {
            inputStream1.connect(outputStream2);
            inputStream2.connect(outputStream1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String msg = "Your Turn";

        new Thread(() -> {
            byte[] buffer = new byte[9];
            try {
                for (char c : numberChar) {
                    inputStream1.read(buffer);
                    if (new String(buffer).equals(msg)) {
                        System.out.print(c);
                    }
                    outputStream1.write(msg.getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }, "t1").start();

        new Thread(() -> {
            byte[] buffer = new byte[9];
            try {
                for (char c : letterChar) {
                    System.out.print(c);
                    outputStream2.write(msg.getBytes());
                    inputStream2.read(buffer);
                    if (new String(buffer).equals(msg)) {
                        continue;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }, "t2").start();

    }
}
