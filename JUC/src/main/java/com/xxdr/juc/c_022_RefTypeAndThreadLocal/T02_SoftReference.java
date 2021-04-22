package com.xxdr.juc.c_022_RefTypeAndThreadLocal;

import java.lang.ref.SoftReference;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/21 20:38
 * @Version 1.0
 */
public class T02_SoftReference {
    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<>(new byte[10 * 1024 * 1024]);
        System.out.println(m.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());
        byte[] b = new byte[12 * 1024 * 1024];
        System.out.println(m.get());
    }

}
