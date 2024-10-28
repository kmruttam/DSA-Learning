package algorithms.searching;

public class ExponentialSearch {
  public static int search(int[] array, int target) {

    int bound = 1;
    while (bound < array.length && array[bound] < target) {
      bound *= 2;
    }

    int left = bound / 2;
    int right = Math.min(bound, array.length - 1);
    return binarySearch(array, target, left, right);
  }

  private static int binarySearch(int[] array, int target, int left, int right) {
    if (right < left) {
      return -1;
    }

    int middle = (left + right) / 2;

    if (array[middle] == target) {
      return middle;
    }

    if (target < array[middle]) {
      return binarySearch(array, target, left, middle - 1);
    }

    return binarySearch(array, target, middle + 1, right);
  }
}
