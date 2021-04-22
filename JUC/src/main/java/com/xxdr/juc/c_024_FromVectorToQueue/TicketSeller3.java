package com.xxdr.juc.c_024_FromVectorToQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/21 22:45
 * @Version 1.0
 */
public class TicketSeller3 {
    static List<String> tickets = new LinkedList<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("ticket id " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <10; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (tickets) {
                        if (tickets.size() <= 0) break;

                        try {
                            TimeUnit.MICROSECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("sell --" + tickets.remove(0));
                    }
                }
            }).start();
        }
    }
}
