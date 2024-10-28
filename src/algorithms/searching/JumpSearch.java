package algorithms.searching;

public class JumpSearch {
  public static int search(int[] array, int target) {
    int blockSize = (int) Math.sqrt(array.length);
    int start = 0;
    int next = blockSize;

    while (start < array.length && array[next - 1] < target) {
      start = next;
      next += blockSize;
      if (next > array.length) {
        next = array.length;
      }
    }

    for (int i = start; i < next; i++) {
      if (target == array[i]) {
        return i;
      }
    }

    return -1;
  }

}
