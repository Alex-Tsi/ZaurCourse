package com.black_belt.course.multithreading;

import lombok.SneakyThrows;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceEx {
    @SneakyThrows
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);

//            scheduledExecutorService.execute(new ScheduledRun());

//            scheduledExecutorService.schedule(new ScheduledRun(), 3, TimeUnit.SECONDS);

//            scheduledExecutorService.shutdown();
//        scheduledExecutorService.scheduleAtFixedRate(new ScheduledRun(), 3, 1, TimeUnit.SECONDS);
//        Thread.sleep(20000);
//        scheduledExecutorService.shutdown();

        scheduledExecutorService.scheduleWithFixedDelay(new ScheduledRun(), 3, 1, TimeUnit.SECONDS);
        scheduledExecutorService.awaitTermination(5, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}

class ScheduledRun implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins work");
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}