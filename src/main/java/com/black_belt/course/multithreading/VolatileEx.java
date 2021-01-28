package com.black_belt.course.multithreading;

import lombok.SneakyThrows;

public class VolatileEx extends Thread {
    volatile boolean b = true;
    //без volatile переменная b будет хранится в 3 местах (в данном случае) : в кэше ядра, на котором работает main
    //в кэше ядре, на котором работает VolatileEx thread и в main memory
    //изменяя переменную, мы меняем значение в кэше ядра текущего потока (то есть мы сделали это в main) и таким образом
    //значение на переменной в main memory не отразилось. И мы не знаем, когда значение из кэша ядра попадет в main memory
    //https://ru.stackoverflow.com/questions/1271/%D0%9A%D0%BB%D1%8E%D1%87%D0%B5%D0%B2%D0%BE%D0%B5-%D1%81%D0%BB%D0%BE%D0%B2%D0%BE-volatile-%D0%B2-java
    volatile int i = 0;
    @SneakyThrows
    @Override
    public void run() {
        int counter = 0;
        System.out.println("Start second thread");
        while (b) {
            counter++;
        }
        while (this.i < 100) {
            Thread.sleep(100);
            this.i++;
            System.out.println(this.i);
        }
        System.out.println(Thread.currentThread().getName() + " value: " + counter);
    }

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("Start main");
        VolatileEx thread = new VolatileEx();
        thread.setName("VolatileEx");
        thread.start();
        Thread.sleep(3000);
        thread.b = false;
        //thread.join();
        while (thread.i < 100) {
            Thread.sleep(100);
            thread.i++;
            System.out.println(thread.i);
        }
        System.out.println("End of main method");
    }
}
