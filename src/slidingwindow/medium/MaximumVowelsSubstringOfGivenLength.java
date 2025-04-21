// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/

package slidingwindow.medium;

public class MaximumVowelsSubstringOfGivenLength {

    public int maxVowels(String str, int k) {
        int length = str.length();
        int backwordPointer = 0, forwardPointer = k-1;
        int initialCount = countVowels(str, backwordPointer, forwardPointer)/k, maxVowels = initialCount;


        while (forwardPointer < length - 1) {
            backwordPointer++;
            forwardPointer++;

            char ch = str.charAt(backwordPointer - 1);
            if (isVowels(ch)) {
                initialCount--;
            }
            ch = str.charAt(forwardPointer);
            if (isVowels(ch)) {
                initialCount++;
            }
            if (initialCount > maxVowels) {
                maxVowels = initialCount;
            }

        }
        return maxVowels;
    }

    private int countVowels(String str, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            char c = str.charAt(i);
            if (isVowels(c)) {
                count++;
            }
        }
        return count;
    }

    private boolean isVowels(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        MaximumVowelsSubstringOfGivenLength m = new MaximumVowelsSubstringOfGivenLength();
        System.out.println(m.maxVowels("abciiidef", 3));
        System.out.println(m.maxVowels("aeiou", 2));
        System.out.println(m.maxVowels("leetcode", 3));
    }
}
