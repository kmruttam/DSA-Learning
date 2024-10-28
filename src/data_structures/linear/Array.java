package data_structures.linear;

public class Array {
    private int[] items;
    private int size = 0;

    public Array(int length) {
        items = new int[length];
    }

    public int indexOf(int item) {
        for (int i = 0; i < size; i++) {
            if (item == items[i]) {
                return i;
            }
        }
        return -1;
    }

    public void insert(int item) {
        if (items.length == size) {
            int[] newItems = new int[size * 2];
            for (int i = 0; i < size; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[size++] = item;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                System.out.print(items[i] + "");
            } else {
                System.out.print(items[i] + ", ");
            }
        }
        System.out.println("]");
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        for (int i = index; i < size; i++) {
            items[i] = items[i + 1];
        }
        size--;
    }
}
