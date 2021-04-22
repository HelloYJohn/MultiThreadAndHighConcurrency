package com.xxdr.juc.c_025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/21 23:34
 * @Version 1.0
 */
public class T03_SynchronizedList {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        List<String> stringListSync = Collections.synchronizedList(stringList);
    }
}
