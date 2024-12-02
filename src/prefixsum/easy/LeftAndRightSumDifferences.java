// https://leetcode.com/problems/left-and-right-sum-differences/description/

package prefixsum.easy;

import java.util.Arrays;

public class LeftAndRightSumDifferences {
    public static int[] leftRightDifference(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        leftSum[0] = nums[0];
        rightSum[nums.length - 1] = nums[nums.length - 1];
        for (int start = 1, end = nums.length - 2; start < nums.length; start++, end--) {
            leftSum[start] = nums[start] + leftSum[start - 1];
            rightSum[end] = nums[end] + rightSum[end + 1];
        }
        for (int start = 0; start < nums.length; start++) {
            leftSum[start] = Math.abs(leftSum[start] - rightSum[start]);
        }
        return leftSum;
    }

    public static void main(String[] args) {
        int[] nums = {10, 4, 8, 3};
        System.out.println(Arrays.toString(leftRightDifference(nums)));
    }
}
