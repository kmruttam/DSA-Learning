
import algorithms.searching.ExponentialSearch;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] blank = {};
        int result = ExponentialSearch.search(numbers, 8);
        int blankResult = ExponentialSearch.search(blank, 0);
        System.out.println("Result: " + result);
        System.out.println("Black Result: " + blankResult);
    }
}