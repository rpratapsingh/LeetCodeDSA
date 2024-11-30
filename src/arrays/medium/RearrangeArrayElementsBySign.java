// https://leetcode.com/problems/rearrange-array-elements-by-sign/description/

package arrays.medium;

public class RearrangeArrayElementsBySign {
    public static int[] rearrangeArray(int[] nums) {
        int[] rearrangedArray = new int[nums.length];
        int positiveIndex = 0;
        int negativeIndex = 1;
        for (int number : nums) {
            if (number <= 0) {
                rearrangedArray[negativeIndex] = number;
                negativeIndex += 2;
            } else {
                rearrangedArray[positiveIndex] = number;
                positiveIndex += 2;
            }
        }
        return rearrangedArray;
    }

    public static void main(String[] args) {
        int[] array = {3, 1, -2, -5, 2, -4};
        int[] sortedArray = rearrangeArray(array);
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
    }
}
