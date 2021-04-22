package com.xxdr.juc.c_024_FromVectorToQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/21 22:40
 * @Version 1.0
 */
public class TicketSeller1 {
    static List<String> tickets = new ArrayList<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("ticket id " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <10; i++) {
            new Thread(() -> {
                while (tickets.size() > 0) {
                    System.out.println("sell --" + tickets.remove(0));
                }
            }).start();
        }
    }
}
