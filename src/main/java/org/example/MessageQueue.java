package org.example;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

    public class MessageQueue {
        private final File queueFile;
        private final Queue<String> queue = new LinkedList<>();

        public MessageQueue(String filename) {
            this.queueFile = new File(filename);
        }

        public synchronized void sendMessage(String message) throws IOException {
            queue.add(message);
            saveQueueToFile();
            notifyAll();
        }

        public synchronized String receiveMessage() throws IOException, InterruptedException {
            while (queue.isEmpty()) {
                wait();
            }
            String message = queue.poll();
            saveQueueToFile();
            return message;
        }

        private void saveQueueToFile() throws IOException {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(queueFile))) {
                for (String message : queue) {
                    writer.write(message);
                    writer.newLine();
                }
            }
        }

        public synchronized void loadQueueFromFile() throws IOException {
            queue.clear();
            if (queueFile.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(queueFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        queue.add(line);
                    }
                }
            }
        }
    }

