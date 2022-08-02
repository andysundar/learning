package com.andy.learning.jdk20;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class VirtualThreadUnmountExample {

    final static BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
    static {
        blockingQueue.add("A");
        blockingQueue.add("B");
    }

    public static void main(String[] args) {
        var virtualThread = Thread.startVirtualThread(() -> {
            System.err.println("Before blocking " + Thread.currentThread());

            try {
                String message = blockingQueue.take();
                System.err.println("After blocking " + Thread.currentThread());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        try {
            virtualThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
