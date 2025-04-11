// https://leetcode.com/problems/next-permutation/description/

package twopointer.medium;

import java.util.Arrays;

import static utils.AllUtils.toArray;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int last = nums.length - 1, newLast = nums.length - 1;
        while (last > 0 && nums[last - 1] >= nums[last]) {
            last--;
        }
        if(last == 0){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        while (newLast >= last && nums[newLast] <= nums[last - 1]) {
            newLast--;
        }

        int temp = nums[last - 1];
        nums[last - 1] = nums[newLast];
        nums[newLast] = temp;

        reverse(nums, last , nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = toArray("1,2,4,3");
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
