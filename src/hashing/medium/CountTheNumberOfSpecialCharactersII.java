// https://leetcode.com/problems/count-the-number-of-special-characters-ii/description/

package hashing.medium;

import java.util.HashMap;
import java.util.Map;

public class CountTheNumberOfSpecialCharactersII {
    public static int numberOfSpecialChars(String word) {
        char[] characters = word.toCharArray();
        Map<Character, Integer> tracker = new HashMap<>();
        for (char letter : characters) {
            if (letter >= 'a' && letter <= 'z') {
                if (tracker.get(letter) == null) {
                    tracker.put(letter, 1);
                } else if (tracker.get(letter) == 2) {
                    tracker.put(letter, 0);
                }
            } else {
                char lowerChar = Character.toLowerCase(letter);
                if (tracker.get(lowerChar) == null) {
                    tracker.put(lowerChar, 0);
                } else if (tracker.get(lowerChar) == 1) {
                    tracker.put(lowerChar, 2);
                }
            }
        }
        int sum = 0;
        for (Map.Entry<Character, Integer> entry : tracker.entrySet()) {
            if (entry.getValue() == 2) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSpecialChars("AbBCab"));
    }
}
