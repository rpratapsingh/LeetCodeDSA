package dynamic.medium;

public class LongestPalindromicSubstring {
    private int length;
    private char[] ch;
    private String longestString;
    private int maxLength = Integer.MIN_VALUE;

    public String longestPalindrome(String str) {
        length = str.length();
        ch = str.toCharArray();
        for (int i = 0; i < length; i++) {
            check(i, i, str);
            check(i, i + 1, str);
        }
        return longestString;
    }

    private void check(int i, int j, String str) {
        while (i >= 0 && j < length && ch[i] == ch[j]) {
            if (j - i > maxLength) {
                longestString = str.substring(i, j+1);
                maxLength = j - i;
            }
            i--;
            j++;
        }
    }
}

class LongestPalindromicSubstringTest {
    public static void main(String[] args) {
        String input = "a";
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome(input));
    }
}
