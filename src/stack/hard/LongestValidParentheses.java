// https://leetcode.com/problems/maximum-frequency-stack/description/

package stack.hard;

import java.util.Stack;


// TODO Unsolved
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        char[] paran = s.toCharArray();
        int current = 0, max = Integer.MIN_VALUE;
        Stack<Character> stack = new Stack<>();
        for (char c : paran) {
            if (stack.isEmpty() && c != ')') {
                stack.push(c);
                continue;
            }
            char ch = stack.peek();
            if (c == ch) {

            }
        }

        return -1;
    }
}


class LongestValidParenthesesTest {
    public static void main(String[] args) {

    }
}
