// https://leetcode.com/problems/di-string-match/description/

package twopointer.easy;

public class DIStringMatch {
    public int[] diStringMatch(String s) {

        int[] result = new int[s.length() + 1];
        int front = 0, back = s.length();

        for (int i = 0; i < s.length(); i++) {
            result[i] = s.charAt(i) == 'I' ? front++ : back--;
        }
        return result;
    }
}
