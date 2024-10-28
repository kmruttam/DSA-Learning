import java.util.Arrays;

import algorithms.sorting.BucketSort;
import algorithms.sorting.CountingSort;

public class Main {
    public static void main(String[] args) {
        int[] numbers = { 5, 1, 7, 2, 6, 4, 1, 5 };
        BucketSort.sort(numbers, 3);
        System.out.println(Arrays.toString(numbers));
    }
}