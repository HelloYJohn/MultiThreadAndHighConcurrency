package com.xxdr.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.Executors;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/24 23:50
 * @Version 1.0
 */
public class Main01 {
    public static void main(String[] args) {
        LongEventFactory longEventFactory = new LongEventFactory();
        int bufferSize = 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(longEventFactory, bufferSize,
                Executors.defaultThreadFactory());

        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        long sequence = ringBuffer.next();
        try {
            LongEvent longEvent = ringBuffer.get(sequence);
            longEvent.setValue(8888L);
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}
