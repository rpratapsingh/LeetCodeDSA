// https://leetcode.com/problems/count-vowel-strings-in-ranges/description/

package prefixsum.medium;

import java.util.Arrays;

public class CountVowelStringsInRanges {
    public static int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] count = new int[words.length];
        int sum = 0;
        for (int index = 0; index < words.length; index++) {
            if (isValidWord(words[index])) {
                sum += 1;
            }
            count[index] = sum;
        }

        for (int index = 0; index < queries.length; index++) {
            int[] query = queries[index];
            if (query[0] == 0) {
                ans[index] = count[query[1]];
            } else {
                ans[index] = count[query[1]] - count[query[0] - 1];
            }
        }
        return ans;
    }

    private static boolean isValidWord(String word) {
        char[] letters = word.toCharArray();
        if (isVowel(letters[0]) && isVowel(letters[word.length() - 1])) {
            return true;
        }
        return false;
    }

    private static boolean isVowel(char letter) {
        if (letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U'
                || letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        String[] words = {"aba", "bcb", "ece", "aa", "e"};
//        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};

        String[] words = {"a","e","i"};
        int[][] queries = {{0, 2}, {0, 1}, {2, 2}};
        System.out.println(Arrays.toString(vowelStrings(words, queries)));
    }
}
