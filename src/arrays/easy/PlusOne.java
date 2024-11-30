// https://leetcode.com/problems/plus-one/description/

package arrays.easy;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int newNumber = 0, carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                newNumber = digits[i] + 1;
            } else {
                newNumber = digits[i] + carry;
            }
            if (newNumber > 9) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] = newNumber;
                carry = 0;
                break;
            }
        }
        if (carry == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }
        return digits;
    }

    public static int[] plusOneAlt(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    public static void main(String[] args) {
        int[][] testCases = {{1, 2, 3}, {4, 3, 2, 9}, {9}};
        for (int[] testCase : testCases) {
            int[] result = plusOne(testCase);
            for (int number : result) {
                System.out.print(number);
            }
            System.out.println("");
        }
    }
}
