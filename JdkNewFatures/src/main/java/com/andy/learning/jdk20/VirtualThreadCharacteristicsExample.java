package com.andy.learning.jdk20;


public class VirtualThreadCharacteristicsExample {

    public static void main(String[] args) throws InterruptedException {
        var virtualThread = Thread
                .ofVirtual()
                .unstarted(()-> System.err.println(Thread.currentThread()));
        virtualThread.start();
        virtualThread.join();
        System.err.println("Class Name :- " + virtualThread.getClass());
    }
}
