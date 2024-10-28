package algorithms.searching;

public class BinarySearchRecursive {
  public static int search(int[] array, int target) {
    return search(array, target, 0, array.length - 1);
  }

  private static int search(int[] array, int target, int left, int right) {
    if (right < left) {
      return -1;
    }

    int middle = (left + right) / 2;

    if (array[middle] == target) {
      return middle;
    }

    if (target < array[middle]) {
      return search(array, target, left, middle - 1);
    }

    return search(array, target, middle + 1, right);
  }
}
