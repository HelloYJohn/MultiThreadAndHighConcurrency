package com.xxdr.disruptor;


import com.lmax.disruptor.EventHandler;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/24 23:46
 * @Version 1.0
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    public static long count = 0;

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        count++;
        System.out.println("[" + Thread.currentThread().getName() + "]" + longEvent + "sequence: " + l);
    }
}
