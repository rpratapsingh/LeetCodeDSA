package dynamic.medium;

import java.util.HashMap;
import java.util.Map;

public class PalindromicSubstrings {
    int[][] memory = new int[10001][10001];
    int count3 = 0;
    int size;
    char[] ch;

    public int countSubstrings(String s) {
        int size = s.length();
        int count = 0;

        Map<String, Integer> memory = new HashMap<>();
        for (int i = 0; i < size; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = i; j < size; j++) {
                count += (isPalindrome(s, i, j) - 1);
            }
        }
        return count;
    }

    private int isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return 2;
        }
        if (memory[start][end] != 0) {
            return memory[start][end];
        }
        if (str.charAt(start) == str.charAt(end)) {
            return memory[start][end] = isPalindrome(str, start + 1, end - 1);
        }
        return memory[start][end] = 1;
    }


    public int countSubstrings2(String s) {
        int size = s.length();
        boolean[][] memory = new boolean[size][size];
        int count = 0;
        for (int length = 1; length <= size; length++) {
            for (int i = 0; i + length - 1 < size; i++) {
                int j = i + length - 1;
                if (length == 1) {
                    memory[i][j] = true;
                } else if (i + 1 == j) {
                    if (s.charAt(i) == s.charAt(j)) {
                        memory[i][j] = true;
                    }
                } else {
                    memory[i][j] = s.charAt(i) == s.charAt(j) && memory[i + 1][j - 1];
                }

                if (memory[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countSubstrings3(String str) {
        size = str.length();
        ch = str.toCharArray();
        for (int i = 0; i < size; i++) {
            check(i, i, str);
            check(i, i + 1, str);
        }
        return count3;
    }

    private void check(int backwordMoving, int forwardMoving, String str) {
        while (backwordMoving >= 0 && forwardMoving < size && ch[backwordMoving] == ch[forwardMoving]) {
            count3++;
            backwordMoving--;
            forwardMoving++;
        }
    }
}

class PalindromicSubstringsTest {
    public static void main(String[] args) {
        PalindromicSubstrings substrings = new PalindromicSubstrings();
        System.out.println(substrings.countSubstrings3("ayeaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaah"));
    }
}