// https://leetcode.com/problems/reverse-vowels-of-a-string/description/

package strings.easy;

import java.util.Arrays;
import java.util.List;

public class ReverseVowelsOfAString {
    public static String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] word = s.toCharArray();
        while (start < end) {
            if (isVowel(word[start]) && isVowel(word[end])) {
                char temp = word[start];
                word[start] = word[end];
                word[end] = temp;
                start++;
                end--;
            }
            if (!isVowel(word[start])) {
                start++;
            }
            if (!isVowel(word[end])) {
                end--;
            }
        }
        return new String(word);
    }

    private static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String word = "leetcode";
        String prefix = reverseVowels(word);
        System.out.println(prefix);
    }
}
