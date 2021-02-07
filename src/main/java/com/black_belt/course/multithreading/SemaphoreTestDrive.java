package com.black_belt.course.multithreading;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class SemaphoreTestDrive {
    private static int sum;

    @SneakyThrows
    public static void main(String[] args) {
        Semaphore phoneStation = new Semaphore(2);
        RandomizeName randomizer = new RandomizeName() {
        };
        ExecutorService service =
                Executors.newFixedThreadPool(5);
        List<Future<Integer>> wholeDuration = new LinkedList<>();
        Future<Integer> singleDuration;
        for (int i = 0; i < 5; i++) {
            singleDuration = service.submit(new Person(randomizer.random(5), phoneStation));
//            System.out.println("Разговор длился " + singleDuration.get());
            wholeDuration.add(singleDuration);
        }

        for (Future<Integer> f :
                wholeDuration) {
            sum += f.get();
        }
        service.awaitTermination(20, TimeUnit.SECONDS);
        System.out.println("Всего говорили по телефону = " + sum);
        service.shutdown();
    }
}

@Data
@AllArgsConstructor
class Person implements Callable<Integer> {
    private final String name;
    private final Semaphore semaphore;

    @SneakyThrows
    @Override
    public Integer call() {
        Random random = new Random();
        int duration = random.nextInt(5) + 1;
        try {
            System.out.println(name + " ждёт...");
            semaphore.acquire(); //interruptedException
            Thread.sleep(duration * 1000);
            System.out.println(name + " договорил(а) по телефону");
            System.out.println(name + " длительность " + duration);
        } finally {
            semaphore.release();
        }
        return duration;
    }
}

interface RandomizeName {
    String alphabet = "ABCDEFGHJKLMNOPQRSTUVWXYZ";

    default String random(int length) {
        Random random = new Random();
        char[] chars = alphabet.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(random.nextBoolean() ?
                    Character.toString(chars[random.nextInt(chars.length)]).toLowerCase() :
                    Character.toString(chars[random.nextInt(chars.length)])
            );
        }
        return result.toString();
    }
}