// https://leetcode.com/problems/reverse-prefix-of-word/description/

package strings.easy;

import java.util.Arrays;

public class ReversePrefixOfWord {

    public static String reversePrefix(String word, char ch) {

        int index = word.indexOf(ch);
        int start = 0;
        int end = index;
        char[] wordArray = word.toCharArray();
        while (start < end) {
            char temp = wordArray[start];
            wordArray[start] = wordArray[end];
            wordArray[end] = temp;
            start++;
            end--;
        }
        return new String(wordArray);
    }

    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        String prefix = reversePrefix(word, ch);
        System.out.println(prefix);
    }
}
