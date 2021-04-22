package com.xxdr.juc.c_024_FromVectorToQueue;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/21 22:43
 * @Version 1.0
 */
public class TicketSeller2 {
    static Vector<String> tickets = new Vector<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("ticket id " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <10; i++) {
            new Thread(() -> {
                while (tickets.size() > 0) {
                    try {
                        TimeUnit.MICROSECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("sell --" + tickets.remove(0));
                }
            }).start();
        }
    }
}
