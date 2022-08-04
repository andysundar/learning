package com.andy.learning.jdk20;


import java.util.concurrent.Executors;

public class VirtualThreadCharacteristicsExample {

    public static void main(String[] args) throws InterruptedException {
        var virtualThread1 = Thread
                .ofVirtual()
                .unstarted(()-> System.err.println(Thread.currentThread()));
        virtualThread1.start();

        var virtualThread2 = Thread.startVirtualThread(()-> System.err.println(Thread.currentThread()));
        var virtualThread3 = Thread.ofVirtual().start(()-> System.err.println(Thread.currentThread()));

        // Virtual thread created with a factory
        var factory = Thread.ofVirtual().factory();
        Thread virtualThreadFromAFactory = factory.newThread(()-> System.err.println(Thread.currentThread()));
        virtualThreadFromAFactory.start();

        Executors.newVirtualThreadPerTaskExecutor();
        Executors.newThreadPerTaskExecutor(factory); // Same as newVirtualThreadPerTaskExecutor
        Executors.newSingleThreadExecutor(factory);
        Executors.newCachedThreadPool(factory);
        Executors.newFixedThreadPool(1, factory);
        Executors.newScheduledThreadPool(1, factory);
        Executors.newSingleThreadScheduledExecutor(factory);


        virtualThread1.join();
        virtualThread2.join();
        virtualThread3.join();
        System.err.println("Class Name :- " + virtualThread1.getClass());
    }
}
