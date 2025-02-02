package algorithms.searching;

public class BinarySearch {
  public static int search(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;

    while (left <= right) {
      int middle = (left + right) / 2;
      if (array[middle] == target) {
        return middle;
      }
      if (target < array[middle]) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return -1;
  }
}
