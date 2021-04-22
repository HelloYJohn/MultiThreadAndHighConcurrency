package com.xxdr.juc.c_022_RefTypeAndThreadLocal;

import java.io.IOException;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/21 20:28
 * @Version 1.0
 */
public class T01_NormalReference {
    public static void main(String[] args) {
        M m = new M();
        m = null;
        System.gc();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
