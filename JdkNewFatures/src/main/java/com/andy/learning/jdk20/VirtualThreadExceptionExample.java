package com.andy.learning.jdk20;

public class VirtualThreadExceptionExample {

    public static void main(String[] args) {
        var virtualThread = Thread.startVirtualThread(() -> {
            try {
                throw new Exception("To test stack trace.");
            } catch (Exception e) {
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
