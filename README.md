﻿# Multithread-Snchronised-Chat_Example  
  
Build a multithreaded system where threads can send and receive messages using files as a medium, you can create a shared message queue that handles file-based communication. 

## This program will have:  
  
1. A MessageQueue class to manage the file-based message queue.
2. A Sender class to send messages to the queue.
3. A Receiver class to receive messages from the queue.
4. A Main class to coordinate the sender and receiver threads.

## Explanation

### MessageQueue Class:

Manages a queue of messages using a file.
sendMessage adds a message to the queue, saves the queue to the file, and notifies waiting threads.
receiveMessage waits for messages if the queue is empty, then retrieves and removes the next message from the queue and updates the file.
saveQueueToFile writes the queue to the file.
loadQueueFromFile reads the queue from the file.

### Sender Class:

Sends messages to the queue.
Sleeps between sending messages to simulate work.

### Receiver Class:

Receives messages from the queue.
Sleeps between receiving messages to simulate work.

### Main Class:

Creates the MessageQueue and loads any existing messages from the file.
Starts the sender and receiver threads and waits for them to complete using join.  
  
Her we demonstrated how to implement a file-based message queue with synchronization in Java, where multiple threads can send and receive messages.
