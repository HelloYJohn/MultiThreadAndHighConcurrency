package com.xxdr.juc.c_025;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @Author John Yuan
 * @Description transfer要等其他人take后才会返回
 * @Date 2021/4/22 22:13
 * @Version 1.0
 */
public class T09_TransferQueue {
    public static void main(String[] args) {
        LinkedTransferQueue<String> linkedTransferQueue = new LinkedTransferQueue<>();

        new Thread(() -> {
            try {
                System.out.println(linkedTransferQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            linkedTransferQueue.transfer("aaa");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
