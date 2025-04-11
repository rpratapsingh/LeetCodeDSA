// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/

package slidingwindow.easy;

public class SubstringsOfDistinctCharacters {
    public static int countGoodSubstrings(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length - 2; i++) {
            if (chars[i] != chars[i + 1] && chars[i] != chars[i + 2] && chars[i + 1] != chars[i + 2]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("aababcabc"));
    }
}
