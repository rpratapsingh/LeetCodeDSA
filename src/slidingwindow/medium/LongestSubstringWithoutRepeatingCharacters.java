// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

package slidingwindow.medium;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int[] visitedIndex = new int[200];
        for (int i = 0; i < 200; i++) {
            visitedIndex[i] = -1;
        }
        int back = 0, front = 0;
        int currentLength = 0;
        int maxLength = 0;
        while (front < length) {
            if (visitedIndex[s.charAt(front)] != -1 && back < visitedIndex[s.charAt(front)]) {
                back = visitedIndex[s.charAt(front)] + 1;
                visitedIndex[s.charAt(front)] = front;
                currentLength = front - back + 1;
            } else {
                visitedIndex[s.charAt(front)] = front;
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            }
            front++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));

    }
}
