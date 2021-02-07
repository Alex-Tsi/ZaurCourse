package com.black_belt.course.multithreading;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PartialSumTestDrive {
    public static long value = 1_000_000_000L;
    public static long sum;

    @SneakyThrows
    public static void main(String[] args) {

        ExecutorService executorService =
                Executors.newFixedThreadPool(10);
        List<Future<Long>> futureList = new ArrayList<>(10);
        Future<Long> future;
        long valueDividedBy10 = value / 10;
        for (int i = 0; i < 10; i++) {
            long from = valueDividedBy10 * i + i;
            long to = valueDividedBy10 * (i + 1);
            future = executorService.submit(new PartialSum(from, to));
            futureList.add(future);
        }
        for (Future<Long> f : futureList) {
            sum += f.get();
        }
        executorService.shutdown();
        System.out.println("Total sum = " + sum);
    }
}

class PartialSum implements Callable<Long> {
    private final long from;
    private final long to;
    private long localSum;

    public PartialSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() {
        for (long i = from; i < to; i++) {
            localSum += i;
        }
        System.out.println("Sum from " + from + " to " + to + " = " + localSum);
        return localSum;
    }
}
