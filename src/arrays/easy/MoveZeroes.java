// https://leetcode.com/problems/move-zeroes/

package arrays.easy;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int zeroPointer = 0, nonZeroPointer = 0;
        while (nonZeroPointer < nums.length) {
            if (nums[zeroPointer] == 0 && nums[nonZeroPointer] != 0) {
                int temp = nums[zeroPointer];
                nums[zeroPointer] = nums[nonZeroPointer];
                nums[nonZeroPointer] = temp;
                zeroPointer++;
            } else if (nums[zeroPointer] != 0) {
                zeroPointer++;
                nonZeroPointer++;
            } else {
                nonZeroPointer++;
            }
        }

    }

    public static void moveZeroesAlt(int[] nums) {
        int snowBallSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowBallSize++;
            } else if (snowBallSize > 0) {
                int t = nums[i];
                nums[i] = 0;
                nums[i - snowBallSize] = t;
            }
        }
    }

    public static void main(String[] args) {
        //int[][] testCases = {{0, 1, 0, 3, 12}, {1, 0, 1}, {0, 1, 0}};
        int[][] testCases = {{1, 0, 1}};
        for (int[] testCase : testCases) {
            moveZeroes(testCase);
            for (int number : testCase) {
                System.out.print(number + " ");
            }
            System.out.println("");
        }
    }
}
