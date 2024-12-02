// https://leetcode.com/problems/reverse-words-in-a-string/description/

package strings.medium;

public class ReverseWordsInAString {
    public static String reverseWords(String s) {

        char[] charArray = s.toCharArray();
        int staticPointer = charArray.length - 1;
        int runningPointer = charArray.length - 1;
        StringBuilder newString = new StringBuilder();
        while (runningPointer >= 0) {
            if (charArray[runningPointer] == ' ' && charArray[staticPointer] == ' ') {
                runningPointer--;
                staticPointer--;
            } else if (charArray[runningPointer] == ' ' || runningPointer == 0) {
                appendString(charArray[runningPointer] == ' ' ? runningPointer + 1 : 0, staticPointer, newString, charArray);
                runningPointer--;
                staticPointer = runningPointer;
            } else if (charArray[runningPointer] != ' ') {
                runningPointer--;
            }
        }
        return newString.toString();
    }

    private static void appendString(int runningPointer, int staticPointer, StringBuilder newString, char[] charArray) {
        if (!newString.isEmpty()) {
            newString.append(" ");
        }
        for (int index = runningPointer; index <= staticPointer; index++) {
            newString.append(charArray[index]);
        }
    }

    public static void main(String[] args) {
        String word = " asdasd df f";
        String prefix = reverseWords(word);
        System.out.println("\"" + prefix + "\"");
    }

}
