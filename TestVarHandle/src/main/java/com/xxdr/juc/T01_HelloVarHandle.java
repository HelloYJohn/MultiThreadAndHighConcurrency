package com.xxdr.juc;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * @ClassName T01_HelloVarHandle
 * @Description TODO
 * @Author John Yuan
 * @Date 4/21/21 4:37 PM
 * @Version 1.0
 */
public class T01_HelloVarHandle {
    int x = 8;
    private static VarHandle handle;
    static {
        try {
            try {
                handle = MethodHandles.lookup().findVarHandle(T01_HelloVarHandle.class, "x", int.class);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        T01_HelloVarHandle t = new T01_HelloVarHandle();
        System.out.println((int)handle.get(t));
        handle.set(t, 9);
        System.out.println(t.x);
        handle.compareAndSet(t, 9, 10);
        System.out.println(t.x);
        handle.getAndAdd(t, 10);
        System.out.println(t.x);
    }

}
