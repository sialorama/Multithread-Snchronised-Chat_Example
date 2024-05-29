package org.example;

import java.io.IOException;

public class Sender extends Thread {
    private final MessageQueue messageQueue;

    public Sender(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                String message = "Message " + i;
                messageQueue.sendMessage(message);
                System.out.println("Sent: " + message);
                Thread.sleep(100); // Simulate time taken to produce the message
            } catch (InterruptedException | IOException e) {
                Thread.currentThread().interrupt();
                System.err.println("Sender interrupted or I/O error: " + e.getMessage());
            }
        }
    }
}
