package com.hejia.threaddemo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: hj
 * @Date: 2021/7/8 18:25
 */
public class ForkJoinDemo {
    private static final int THREADHOLD = 500;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int max = Integer.MAX_VALUE / 10;
        int[] arrays = new int[max];
        for (int i = 0; i < max; i++) {
            arrays[i] = i;
        }
        long start1 = System.currentTimeMillis();
        int sum1 = 0;
        for (int i = 0; i < arrays.length; i++) {
            sum1 += arrays[i];
        }
        System.out.println("单线程:" + sum1);
        System.out.println("单线程用时:" + (System.currentTimeMillis() - start1));
        long start2 = System.currentTimeMillis();
        Task task = new Task(arrays, 0, max - 1);
//        Integer sum2 = ForkJoinPool.commonPool().invoke(task);
        ForkJoinTask<Integer> result = ForkJoinPool.commonPool().submit(task);
        Integer sum2 = result.get();
        System.out.println("Fork/Join:" + sum2);
        System.out.println("Fork/Join用时:" + (System.currentTimeMillis() - start2));
    }

    public static class Task extends RecursiveTask<Integer> {
        private int[] arrays;

        private int start;

        private int end;

        public Task(int[] arrays, int start, int end) {
            this.arrays = arrays;
            this.start = start;
            this.end = end;
        }


        @Override
        protected Integer compute() {
            if (end - start < THREADHOLD) {
                int sum = 0;
                for (int i = start;i <= end; i ++) {
                    sum += arrays[i];
                }
                return sum;
            }
            int middle = (start + end) / 2;
            Task task1 = new Task(arrays, start, middle);
            Task task2 = new Task(arrays, middle + 1, end);
            task1.fork();
            task2.fork();
            Integer sum1 = task1.join();
            Integer sum2 = task2.join();
            return sum1 + sum2;
        }
    }
}
