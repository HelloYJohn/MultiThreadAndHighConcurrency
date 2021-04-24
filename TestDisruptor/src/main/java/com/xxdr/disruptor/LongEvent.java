package com.xxdr.disruptor;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/24 23:40
 * @Version 1.0
 */
public class LongEvent {
    private long value;

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "LongEvent{" +
                "value=" + value +
                '}';
    }
}
