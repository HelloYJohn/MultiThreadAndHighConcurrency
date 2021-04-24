package com.xxdr.jmh;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/24 23:19
 * @Version 1.0
 */
public class PSTest {
    @Benchmark
    public void voidForEach() {
        PS.foreach();
    }
}
