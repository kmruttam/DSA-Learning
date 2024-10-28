package data_structures.linear;

import java.util.Arrays;

public class ArrayQueue {
    private int[] queue;
    private int front = 0;
    private int rear = 0;
    private int size = 0;

    public ArrayQueue(int size) {
        queue = new int[size];
    }

    public void enqueue(int item) {
        if (size == queue.length) {
            throw new IllegalStateException();
        }
        queue[rear] = item;
        rear = (rear + 1) % queue.length;
        size++;
    }

    public int dequeue() {
        int item = queue[front];
        queue[front] = 0;
        front = (front + 1) % queue.length;
        size--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
