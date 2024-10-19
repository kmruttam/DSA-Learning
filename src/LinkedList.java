import java.util.NoSuchElementException;

public class LinkedList {
  private class Node {
    private int value;
    private Node next;

    public Node(int value) {
      this.value = value;
    }
  }

  private Node first;
  private Node last;
  private int size;

  private boolean isEmpty() {
    return first == null;
  }

  public void addLast(int item) {
    var node = new Node(item);
    if (isEmpty()) {
      first = last = node;
    } else {
      last.next = node;
      last = node;
    }
    size++;
  }

  public void addFirst(int item) {
    var node = new Node(item);

    if (isEmpty()) {
      first = last = node;
    } else {
      node.next = first;
      first = node;
    }
    size++;
  }

  public void removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    if (first == last) {
      first = last = null;
    } else {
      Node second = first.next;
      first.next = null;
      first = second;
    }

    size--;
  }

  public void removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    if (first == last) {
      first = last = null;
    } else {
      Node previous = getPrevious(last);
      last = previous;
      last.next = null;
    }
    size--;
  }

  private Node getPrevious(Node node) {
    Node current = first;
    while (current != null) {
      if (current.next == node) {
        return current;
      }
      current = current.next;
    }
    return null;
  }

  public boolean contains(int item) {
    return indexOf(item) != -1;
  }

  public int indexOf(int item) {
    int index = 0;
    Node current = first;
    while (current != null) {
      if (current.value == item) {
        return index;
      }
      current = current.next;
      index++;
    }
    return -1;
  }

  public void print() {
    Node current = first;
    System.out.print("[");
    while (current != null) {
      System.out.print(current.value);
      if (current == last) {
        System.out.print("");
      } else {
        System.out.print(", ");
      }
      current = current.next;
    }
    System.out.println("]");
  }

  public int size() {
    return size;
  }

  public int[] toArray() {
    int[] items = new int[size];
    Node current = first;
    int index = 0;
    while (current != null) {
      items[index++] = current.value;
      current = current.next;
    }
    return items;
  }

  public void reverse() {
    if (isEmpty()) {
      return;
    }

    Node previous = first;
    Node current = first.next;
    while (current != null) {
      Node next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    last = first;
    last.next = null;
    first = previous;
  }

  public int getKthFromTheEnd(int k) {
    if (isEmpty() || k < 1) {
      throw new IllegalArgumentException();
    }
    Node a = first;
    Node b = first;
    for (int i = 0; i < k - 1; i++) {
      b = b.next;
      if (b == null) {
        throw new IllegalArgumentException();
      }
    }
    while (b != last) {
      a = a.next;
      b = b.next;
    }
    return a.value;
  }
}
