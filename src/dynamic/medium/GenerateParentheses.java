package dynamic.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        int open = 0, close = 0;
        findValidParan(n, "", open, close);
        return result;
    }

    private void findValidParan(int pairLength, String paran, int open, int close) {
        if (paran.length() == pairLength * 2) {
            result.add(paran);
            return;
        }
        if (open < pairLength) {
            paran += "(";
            findValidParan(pairLength, paran, open + 1, close);
            paran = paran.substring(0, paran.length() - 1);
        }

        if (close < open) {
            paran += ")";
            findValidParan(pairLength, paran, open, close + 1);
            paran = paran.substring(0, paran.length() - 1);
        }
    }

    private boolean isValid(String str) {
        char[] paran = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : paran) {
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                char top = stack.peek();
                if (top == '(' && ch == ')') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.isEmpty();
    }
}


class GenerateParenthesesTest {
    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        for (String str : generateParentheses.generateParenthesis(3)) {
            System.out.println(str);
        }
    }
}
