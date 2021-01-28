package com.black_belt.course.multithreading;

import lombok.SneakyThrows;

public class SynchronizedMethod {

    static SynchronizedMethod method = new SynchronizedMethod();

    int counter = 0;

    public synchronized void increment() {
        counter++;
        System.out.println(counter);
    }

    @SneakyThrows
    public static void main(String[] args) {
        Thread one = new Thread(new R());
        Thread two = new Thread(new R());
        one.start();
        two.start();
        one.join();
        two.join();
    }
}

class R implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(10);
            SynchronizedMethod.method.increment();
        }
    }
}