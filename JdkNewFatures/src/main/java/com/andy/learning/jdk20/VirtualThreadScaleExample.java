package com.andy.learning.jdk20;

import java.time.Duration;
import java.util.concurrent.ThreadFactory;
import java.util.stream.IntStream;

public class VirtualThreadScaleExample {

    private static final ThreadFactory THREAD_FACTORY = Thread
            .ofVirtual() //.ofPlatform()
            .name("Andy's-custom-factory-",0)
            .factory();

    public static void main(String[] args) {
        System.out.println("Inside main");
        final VirtualThreadScaleExample varThreadExample = new VirtualThreadScaleExample();
        IntStream.range(0, 1_000_000).forEach(

                counter -> THREAD_FACTORY.newThread(() -> varThreadExample.simpleWork(counter)).start()
        );
        try {
            Thread.sleep(Duration.ofSeconds(12));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End main");
    }

    private void simpleWork(int counter) {
        System.out.println("Start " + Thread.currentThread().getName());
        try {
            System.out.println("Is virtual thread ? \n"+ (Thread.currentThread().isVirtual() ? "Yes " : "No ") + counter);
            Thread.sleep(Duration.ofSeconds(1));
            System.out.println("End " +Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
