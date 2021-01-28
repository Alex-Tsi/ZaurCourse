package com.black_belt.course.multithreading;

public class DeadLock {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread one = new Thread(new LockOne());
        Thread two = new Thread(new LockTwo());
        one.start();
        two.start();
    }
}


class LockOne implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread10: Попытка захватить монитор объекта lock1");
        synchronized (DeadLock.lock1) {
            System.out.println("Thread10: Монитор объекта lock1 захвачен");
            System.out.println("Thread10: Попытка захватить монитор объекта lock2");
            synchronized (DeadLock.lock2) {
                System.out.println("Монитор объекта lock2 захвачен");
            }
        }
    }
}

class LockTwo implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread20: Попытка захватить монитор объекта lock2");
        synchronized (DeadLock.lock2) {
            System.out.println("Thread20: Монитор объекта lock2 захвачен");
            System.out.println("Thread20: Попытка захватить монитор объекта lock1");
            synchronized (DeadLock.lock1) {
                System.out.println("Монитор объекта lock1 захвачен");
            }
        }
    }
}
/**
 * Чтобы избежать такой ситуации, очередность захвата локов у всех объектов должна быть одинакова
 */