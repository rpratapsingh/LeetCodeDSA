// https://leetcode.com/problems/valid-parentheses/

package arrays.easy;

public class ValidParentheses {
    public static boolean isValid(String s) {

        char[] stack = new char[s.length()];
        int stackPointer = -1;

        char[] parentheses = s.toCharArray();
        for (char c : parentheses) {
            if (stackPointer == -1 && (c == ')' || c == ']' || c == '}')) {
                return false;
            }
            if (c == ')') {
                if (stack[stackPointer] == '(') {
                    stackPointer--;
                } else {
                    stack[stackPointer] = c;
                    stackPointer++;
                }
            } else if (c == ']') {
                if (stack[stackPointer] == '[') {
                    stackPointer--;
                } else {
                    stack[stackPointer] = c;
                    stackPointer++;
                }
            } else if (c == '}') {
                if (stack[stackPointer] == '{') {
                    stackPointer--;
                } else {
                    stack[stackPointer] = c;
                    stackPointer++;
                }
            } else {
                stack[++stackPointer] = c;
            }
        }
        return stackPointer == -1;
    }

    public static void main(String... args) throws InterruptedException {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([{}])"));
    }
}
