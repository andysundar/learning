package com.andy.learning.jdk20;

import java.time.Duration;
import java.util.stream.IntStream;

public class VirtualThreadContinuationExample {


    public static void main(String[] args)  {
        var virtualThreads =
            IntStream.range(1, 3).mapToObj(counter -> Thread.ofVirtual().unstarted(
                    () -> {
                        System.err.println(String.format("Virtual Thread # %d is mounted to platform thread.", counter));
                        if (counter == 1) {
                            System.err.println(String.format("*** Before Sleep %s ***", Thread.currentThread()) );
                        }
                        try {
                            System.err.println(String.format("Virtual Thread # %d will be unmounted from platform thread.", counter));
                            Thread.sleep(Duration.ofSeconds(2));
                            System.err.println(String.format("Virtual Thread # %d is re-mounted to platform thread.", counter));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        if (counter == 1) {
                            System.err.println(String.format("*** After sleep %s ***", Thread.currentThread()));
                        }

                    })
            ).toList();

        virtualThreads.forEach(Thread::start);

        for (Thread virtualThread:
             virtualThreads) {
            try {
                virtualThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
