package org.example;

import java.io.IOException;

public class Receiver extends Thread {
    private final MessageQueue messageQueue;

    public Receiver(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                String message = messageQueue.receiveMessage();
                System.out.println("Received: " + message);
                Thread.sleep(150); // Simulate time taken to process the message
            } catch (InterruptedException | IOException e) {
                Thread.currentThread().interrupt();
                System.err.println("Receiver interrupted or I/O error: " + e.getMessage());
            }
        }
    }
}
