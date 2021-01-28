package com.black_belt.course.multithreading;

import lombok.SneakyThrows;

public class SleepAndJoin {
    @SneakyThrows
    public static void main(String[] args) {
        Thread one = new Thread(new MyRunnable1());
        System.out.printf("%s", one.getState() + "\n");
        Thread two = new Thread(new MyRunnable2());
        System.out.printf("%s", two.getState() + "\n");
        one.start();
        System.out.println(one.getState());
        two.start();

        one.join(); //Говорим текущему потоку (main) дождаться окончания one потока
        two.join(); //и two потока
        //one.join(5000); поток main ждёт 5 секунд или продолжает, если он первый завершил работу раньше 5-ти секунд
        System.out.println("End of main method");
        System.out.println(one.getState());
    }
}

class MyRunnable1 implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        Thread.currentThread().setName("First");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class MyRunnable2 implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        Thread.currentThread().setName("Second");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
        }
    }
}
