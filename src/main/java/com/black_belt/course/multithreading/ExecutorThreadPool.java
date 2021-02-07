package com.black_belt.course.multithreading;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorThreadPool {
    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
//        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            service.execute(new ThreadForPool());
        }
        service.awaitTermination(5, TimeUnit.SECONDS); //ждёт 5 секунд и продолжает
        //аналогично thread.join(); Также заставляет вызывающий поток ждать N-е количество времени
        service.shutdown();
        //Если не закрыть сервис, то он так и будет висеть и этот пул будет ждать новые задания для своих потоков
        System.out.println("main ends");
    }
    //Сервис уже имеет в себе определенное количество потоков (5 в данном случае) и мы ему отдаем только задания
}

class ThreadForPool implements Runnable {
    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(500);
    }
}
