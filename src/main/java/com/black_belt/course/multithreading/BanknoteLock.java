package com.black_belt.course.multithreading;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BanknoteLock {
    @SneakyThrows
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Employee emp1 = new Employee("Elena", lock);
        Employee emp2 = new Employee("Alex", lock);
        Employee emp3 = new Employee("Maria", lock);
        Employee emp4 = new Employee("Ann", lock);

        Thread thread1 = new Thread(emp1);
        Thread thread2 = new Thread(emp2);
        Thread thread3 = new Thread(emp3);
        Thread thread4 = new Thread(emp4);

        thread1.start();
        thread2.start();
        Thread.sleep(5000);
        thread3.start();
        thread4.start();
    }
}

@Data
@AllArgsConstructor
class Employee implements Runnable {
    private String name;
    private Lock lock;


    @Override
    public void run() {
//        if (lock.tryLock()) {    //если не получается заблокировать, то уходим в else
            System.out.println(name + " ждёт...");
            lock.lock();
            System.out.println(name + " пользуется банкоматом");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println(name + " завершил пользоваться банкоматом");
//        } else {
//            System.out.println(name + " не хочет ждать");
//        }
    }
}
