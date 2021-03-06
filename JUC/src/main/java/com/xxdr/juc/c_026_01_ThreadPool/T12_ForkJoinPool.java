package com.xxdr.juc.c_026_01_ThreadPool;

import com.xxdr.juc.c_001.T;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * @Author John Yuan
 * @Description //TODO
 * @Date 2021/4/24 22:37
 * @Version 1.0
 */
public class T12_ForkJoinPool {
    static int[] nums = new int[1000000];
    static final int MAX_NUM = 50000;
    static Random r = new Random();

    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100);
        }
        System.out.println("static: " + Arrays.stream(nums).sum());
    }

    static class AddTask extends RecursiveAction {
        int start, end;

        public AddTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                System.out.println("from:" + start + " to:" + end + " = " + sum);
            } else {
                int middle = start + (end - start)/2;

                AddTask subTask1 = new AddTask(start, middle);
                AddTask subTask2 = new AddTask(middle, end);
                subTask1.fork();
                subTask2.fork();
            }
        }
    }

    static class AddTaskRet extends RecursiveTask<Long> {
        private static final long serialVersionUID = 1L;

        int start, end;

        public AddTaskRet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                return sum;
            } else {
                int middle = start + (end - start)/2;

                AddTaskRet subTask1 = new AddTaskRet(start, middle);
                AddTaskRet subTask2 = new AddTaskRet(middle, end);
                subTask1.fork();
                subTask2.fork();

                return subTask1.join()+subTask2.join();
            }
        }
    }

    public static void main(String[] args) {
        T12_ForkJoinPool temp = new T12_ForkJoinPool();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        AddTask task = new AddTask(0, nums.length);
        forkJoinPool.execute(task);
        task.join();


//        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        AddTaskRet task = new AddTaskRet(0, nums.length);
//        forkJoinPool.execute(task);
//        long result = task.join();
//        System.out.println(result);
    }
}
