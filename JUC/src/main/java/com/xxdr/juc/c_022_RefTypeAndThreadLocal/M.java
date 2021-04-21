package com.xxdr.juc.c_022_RefTypeAndThreadLocal;

/**
 * @ClassName M
 * @Description TODO
 * @Author John Yuan
 * @Date 4/21/21 5:29 PM
 * @Version 1.0
 */
public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
