package com.black_belt.course.multithreading;


import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.*;

public class CallableFactorial {
//    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(new Factorial(5));
        try {
            System.out.println(future.isDone()); //если выполнен
            System.out.println("before get result");
            System.out.println(future.get());
            System.out.println("after get result");
            System.out.println(future.isDone());
//            service.awaitTermination(5, TimeUnit.SECONDS); //не требуется, т.к. future поток вернётся к мейн,
//            только после того, как future.get() вернет результат

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}

@AllArgsConstructor
class Factorial implements Callable<Integer> {

    int lastNum;

    @SneakyThrows
    @Override
    public Integer call() throws RuntimeException {
        if (lastNum <= 0) throw new RuntimeException("bad constructor argument");
        int result = 1;
        for (int i = 1; i < lastNum + 1; i++) {
            result *= i;
        }
        Thread.sleep(1000);
        return result;
    }
}


/*static int factorial;

    @SneakyThrows
    public static void main(String[] args) {
        Thread factorial = new Thread(new Factorial(6));
        factorial.start();
        factorial.join();
        System.out.println(CallableFactorial.factorial);
    }*/
/*
class Factorial implements Runnable {

    int lastNum;
    int result = 1;

    public Factorial(int lastNum) {
        this.lastNum = lastNum;
    }

    @Override
    public void run() {
        if (lastNum <= 0) {
            System.out.println("Exception");
            return;
        }
        for (int i = 1; i < lastNum + 1; i++) {
            result *= i;
        }
        CallableFactorial.factorial = result;
    }
}
*/
