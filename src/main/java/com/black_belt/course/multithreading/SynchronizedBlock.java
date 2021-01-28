package com.black_belt.course.multithreading;

import lombok.SneakyThrows;
import lombok.ToString;

@ToString
public class SynchronizedBlock {
    public static SynchronizedBlock block = new SynchronizedBlock();
    public static final Object lock;
    int k = 10;

    static {
        lock = new Object();
    }

    @SneakyThrows
    public void whatsappCall() {
        synchronized (lock) { //сменить  на this, чтобы убедиться, что мьютекс захватывается у объекта,
            //метод которого вызывается потоком
            System.out.println(this);
            Thread.sleep(2000);
            System.out.println("Whatsapp call started");
            Thread.sleep(5000);
            System.out.println("Whatsapp call ended");
        }
    }

    @SneakyThrows
    public void skypeCall() {
        synchronized (lock) {
            System.out.println(this);
            Thread.sleep(2000);
            System.out.println("Skype call started");
            Thread.sleep(5000);
            System.out.println("Skype call ended");
        }
    }

    @SneakyThrows
    public void mobileCall() {
//        synchronized (lock) { //т.к. здесь блок кода не синхронизирован, то и метод вызовется без проблем, хоть выше
        //мьютекс объект занят с помощью synchronized, а тут нет.
        System.out.println(this);
        Thread.sleep(2000);
        System.out.println("Mobile call started");
        Thread.sleep(5000);
        System.out.println("Mobile call ended");
//        }
    }

    public static void main(String[] args) {
        Thread wp = new Thread(new RunWhatsappCall());
        Thread sp = new Thread(new RunSkypeCall());
        Thread mp = new Thread(new RunMobileCall());

        wp.start();
        sp.start();
        mp.start();
    }
}

class RunWhatsappCall implements Runnable {
    @Override
    public void run() {
//        new SynchronizedBlock().whatsappCall();
        SynchronizedBlock.block.whatsappCall();
    }
}

class RunSkypeCall implements Runnable {
    @Override
    public void run() {
//        new SynchronizedBlock().skypeCall();
        SynchronizedBlock.block.skypeCall();
    }
}

class RunMobileCall implements Runnable {
    @Override
    public void run() {
//        new SynchronizedBlock().mobileCall();
        SynchronizedBlock.block.mobileCall();
    }
}
