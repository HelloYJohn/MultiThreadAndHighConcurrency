package com.xxdr.juc.c_025;

import java.util.PriorityQueue;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/22 22:08
 * @Version 1.0
 */
public class T07_01_PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();

        q.add("c");
        q.add("e");
        q.add("a");
        q.add("d");
        q.add("b");

        for (int i = 0; i < 5; i++) {
            System.out.println(q.poll());
        }
    }
}
