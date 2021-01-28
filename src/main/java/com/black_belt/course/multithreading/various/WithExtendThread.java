package com.black_belt.course.multithreading.various;

public class WithExtendThread {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.setName("First thread");
        Thread2 thread2 = new Thread2();
        thread2.setName("Second thread");
        thread1.start();
        thread2.start();

    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + " value: " + i);
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + " value: " + i);
        }
    }
}


