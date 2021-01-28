package com.black_belt.course.multithreading.various;

public class WithImplementationRunnable {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadRun1());
        thread1.setName("First thread");
        Thread thread2 = new Thread(new ThreadRun2());
        thread2.setName("Second thread");
        thread1.start();
        thread2.start();
    }

    static void race() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + " value: " + i);
        }
    }
}

class ThreadRun1 implements Runnable {

    @Override
    public void run() {
        WithImplementationRunnable.race();
    }
}

class ThreadRun2 implements Runnable {

    @Override
    public void run() {
        WithImplementationRunnable.race();
    }
}