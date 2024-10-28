package algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
  public static void sort(int[] array, int numberOfBuckets) {
    int i = 0;
    for (List<Integer> bucket : createBuckets(array, numberOfBuckets)) {
      Collections.sort(bucket);
      for (int item : bucket) {
        array[i++] = item;
      }
    }
  }

  private static List<List<Integer>> createBuckets(int[] array, int numberOfBuckets) {
    List<List<Integer>> buckets = new ArrayList<>();
    for (int i = 0; i < numberOfBuckets; i++) {
      buckets.add(new ArrayList<>());
    }
    for (int item : array) {
      buckets.get(item / numberOfBuckets).add(item);
    }
    return buckets;
  }
}
