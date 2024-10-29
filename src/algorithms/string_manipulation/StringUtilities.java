package algorithms.string_manipulation;

import java.util.*;

public class StringUtilities {
  public static int countVowels(String word) {
    if (word == null) {
      return 0;
    }
    int count = 0;
    String vowels = "aeiou";
    for (char ch : word.toLowerCase().toCharArray()) {
      if (vowels.indexOf(ch) != -1) {
        count++;
      }
    }
    return count;
  }

  public static String reverse(String word) {
    if (word == null) {
      return "";
    }
    StringBuilder reversed = new StringBuilder();
    for (int i = word.length() - 1; i >= 0; i--) {
      reversed.append(word.charAt(i));
    }
    return reversed.toString();
  }

  public static String reverseWords(String sentence) {
    if (sentence == null) {
      return "";
    }
    String[] words = sentence.trim().split(" ");
    Collections.reverse(Arrays.asList(words));
    return String.join(" ", words);
  }

  public static boolean areRotations(String string1, String string2) {
    if (string1 == null || string2 == null) {
      return false;
    }
    return (string1.length() == string2.length() && (string1 + string2).contains(string2));
  }

  public static String removeDuplicates(String str) {
    if (str == null) {
      return "";
    }
    StringBuilder output = new StringBuilder();
    Set<Character> seen = new HashSet<>();
    for (char ch : str.toCharArray()) {
      if (!seen.contains(ch)) {
        seen.add(ch);
        output.append(ch);
      }
    }
    return output.toString();
  }

  public static char getMaxOccurringChar(String str) {
    if (str.isEmpty() || str == null) {
      throw new IllegalArgumentException();
    }

    final int ASCII_SIZE = 256;
    int[] frequencies = new int[ASCII_SIZE];

    for (char ch : str.toCharArray()) {
      frequencies[ch]++;
    }

    int max = 0;
    char result = ' ';

    for (int i = 0; i < frequencies.length; i++) {
      if (frequencies[i] > max) {
        max = frequencies[i];
        result = (char) i;
      }
    }

    return result;
  }

  @SuppressWarnings("null")
  public static String capitalize(String sentence) {
    if (sentence == null && sentence.trim().isEmpty()) {
      return "";
    }
    String[] words = sentence.trim().replaceAll(" +", " ").split(" ");
    for (int i = 0; i < words.length; i++) {
      words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
    }
    return String.join(" ", words);
  }

  public static boolean areAnagrams(String first, String second) {
    if (first == null || second == null) {
      return false;
    }

    char[] firstArray = first.toCharArray();
    Arrays.sort(firstArray);

    char[] secondArray = second.toCharArray();
    Arrays.sort(secondArray);

    return Arrays.equals(firstArray, secondArray);
  }

  public static boolean areAnagrams2(String first, String second) {
    if (first == null || second == null) {
      return false;
    }

    final int ENGLISH_ALPHABETS = 26;
    int[] frequencies = new int[ENGLISH_ALPHABETS];

    first = first.toLowerCase();
    for (int i = 0; i < first.length(); i++) {
      frequencies[first.charAt(i) - 'a']++;
    }

    second = second.toLowerCase();
    for (int i = 0; i < second.length(); i++) {
      int index = second.charAt(i) - 'a';
      if (frequencies[index] == 0) {
        return false;
      }
      frequencies[index]--;
    }

    return true;
  }

  public static boolean isPalindrome(String word) {
    if (word == null) {
      return false;
    }
    int left = 0;
    int right = word.length() - 1;
    while (left < right) {
      if (word.charAt(left++) != word.charAt(right--)) {
        return false;
      }
    }
    return true;
  }
}
