package com.xxdr.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/24 23:41
 * @Version 1.0
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
