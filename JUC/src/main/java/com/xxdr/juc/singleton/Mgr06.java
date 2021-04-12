package com.xxdr.juc.singleton;

/**
 * @Author John Yuan
 * @Description new Mgr06()分成3个步骤 1. 给指令申请内存 2. 给成员变量初始化 3. 把这块内存的内容赋值给INSTANCE
 * @Date 2021/4/11 15:56
 * @Version 1.0
 */
public class Mgr06 {
    private static volatile Mgr06 INSTANCE;
    
    private Mgr06() {}
    
    public static Mgr06 getInstance() {
        
        if (INSTANCE == null) {
            synchronized (Mgr06.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }
    
    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Mgr06.getInstance().hashCode())).start();
        }
    }
}
