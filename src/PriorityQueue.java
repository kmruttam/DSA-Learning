import java.util.Arrays;

public class PriorityQueue {
    private int[] queue;
    private int size = 0;

    public PriorityQueue(int size) {
        queue = new int[size];
    }

    public void add(int item) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        int index = shiftItemsToInsert(item);
        queue[index] = item;
        size++;
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        int value = queue[size - 1];
        queue[--size] = 0;
        return value;
    }

    public boolean isFull() {
        return queue.length == size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int shiftItemsToInsert(int item) {
        int i;
        for (i = size - 1; i >= 0; i--) {
            if (item < queue[i]) {
                queue[i + 1] = queue[i];
            } else {
                break;
            }
        }
        return i + 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
