package com.andy.learning.jdk20;

import java.time.Duration;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class VirtualThreadPinningExample {

    private final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        VirtualThreadPinningExample obj = new VirtualThreadPinningExample();
        var virtualThreads = IntStream.range(0, 10).mapToObj(
                (counter) -> Thread.ofVirtual().unstarted(
                        () -> {
                            if(counter ==0 ) {
                                System.err.println("Before sync method" + Thread.currentThread());
                                obj.syncMethod();
                                System.err.println("After sync method" + Thread.currentThread());
                            }
                            if(counter ==3 ) {
                                System.err.println("Before lock method" + Thread.currentThread());
                                obj.lockMethod();
                                System.err.println("After lock method" + Thread.currentThread());
                            }
                        }
                )
        ).toList();

        virtualThreads.forEach(Thread::start);
        for (Thread virtualThread : virtualThreads) {
            try {
                virtualThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    synchronized void syncMethod() {
        System.err.println("Inside syncMethod");
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void lockMethod() {
        try {
            lock.lock();
            System.err.println("Inside lockMethod");
            Thread.sleep(Duration.ofSeconds(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
