package com.black_belt.course.multithreading;

import lombok.SneakyThrows;

public class Interrupt {
    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("main started");
        InterruptedThread thread = new InterruptedThread();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();

        thread.join();
        System.out.println("End of main");
    }
}

class InterruptedThread extends Thread {

    double sqrtSum = 0;

    @Override
    public void run() {
        for (int i = 1; i < 1000000; i++) {
            if (isInterrupted()) {
                System.out.println("Поток хотят прервать");
                System.out.println("Мы убедились, что состояние всех объектов" +
                        "в порядке и завершаем работу потока");
                System.out.println(sqrtSum);
                return;
            }
            sqrtSum += Math.sqrt(i);
            /*try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Поток пытались прервать во время его сна");
                System.out.println("Завершаем его работу");
                System.out.println(sqrtSum);
                return;
            }*/

        }
        System.out.println(sqrtSum);
    }
}
