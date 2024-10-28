package data_structures.linear;

import java.util.Stack;

public class StackQueue {
    private Stack<Integer> enqueueStack = new Stack<>();
    private Stack<Integer> dequeueStack = new Stack<>();

    public void enqueue(int item) {
        enqueueStack.push(item);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        moveEnqueueToDequeue();
        return dequeueStack.pop();
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        moveEnqueueToDequeue();
        return dequeueStack.peek();
    }

    private void moveEnqueueToDequeue() {
        if (dequeueStack.empty()) {
            while (!enqueueStack.empty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
    }

    public boolean isEmpty() {
        return enqueueStack.empty() && dequeueStack.empty();
    }
}
