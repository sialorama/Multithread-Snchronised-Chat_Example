package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue("messageQueue.txt");

        // Load existing messages from file (if any)
        try {
            messageQueue.loadQueueFromFile();
        } catch (IOException e) {
            System.err.println("Error loading message queue from file: " + e.getMessage());
        }

        Sender sender = new Sender(messageQueue);
        Receiver receiver = new Receiver(messageQueue);

        sender.start();
        receiver.start();

        try {
            sender.join();
            receiver.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
            Thread.currentThread().interrupt();
        }

        System.out.println("All messages have been sent and received.");
    }
}
