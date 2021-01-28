package com.black_belt.course.multithreading;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.var;

public class WaitNotify {
    @SneakyThrows
    public static void main(String[] args) {
        var market = new Market();
        var producer = new Producer(market);
        var consumer = new Consumer(market);
        var prodThread = new Thread(producer);
        var consThread = new Thread(consumer);
        
        prodThread.start();
        consThread.start();
    }
}

class Market {
    private int breadCount;
    public static final Object lock = new Object();

    @SneakyThrows
    public synchronized void consumeBread() {
        while (breadCount < 1) wait();

        synchronized (lock) {
            breadCount--;
        }
        System.out.println("Потребитель забрал 1 хлеб");
        System.out.println("Осталось " + breadCount + " хлеба");
        notify();
    }

    @SneakyThrows
    public synchronized void produceBread() {
        while (breadCount >= 5) {
            wait(5);
        }

        breadCount++;
        System.out.println("Производитель добавил 1 хлеб");
        System.out.println("Осталось " + breadCount + " хлеба");
        notify();
    }
}

@Data
@AllArgsConstructor
class Producer implements Runnable {
    private Market market;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.produceBread();
        }
    }
}

@Data
@AllArgsConstructor
class Consumer implements Runnable {
    private Market market;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.consumeBread();
        }
    }
}
