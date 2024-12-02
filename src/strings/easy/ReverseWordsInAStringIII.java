// https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
package strings.easy;

public class ReverseWordsInAStringIII {

    public static String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        int runningPointer = 0;
        int slowPointer = 0;
        while (runningPointer < charArray.length) {
            if (charArray[runningPointer] == ' ' || runningPointer == charArray.length - 1) {
                int start = slowPointer;
                int end = runningPointer - 1;
                if (runningPointer == charArray.length - 1) {
                    end = runningPointer;
                }
                while (start < end) {
                    char temp = charArray[start];
                    charArray[start] = charArray[end];
                    charArray[end] = temp;
                    start++;
                    end--;
                }
                runningPointer++;
                slowPointer = runningPointer;
            } else {
                runningPointer++;
            }
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        String word = "Let's take LeetCode contest";
        String prefix = reverseWords(word);
        System.out.println("\"" + prefix + "\"");
    }
}
