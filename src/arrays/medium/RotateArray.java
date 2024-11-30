// https://leetcode.com/problems/rotate-array/description/

package arrays.medium;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        rotate(0, length - 1, nums);
        rotate(0, k - 1, nums);
        rotate(k, length - 1, nums);
    }

    private static void rotate(int start, int end, int[] nums) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        // in: {1,2,3,4,5,6,7}; rotation = 3;| {1, 2, 3, 4, 5, 6, 7, 8}; rotation = 5;
        // out: 5 6 7 1 2 3 4  | 4 5 6 7 8 1 2 3

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int rotation = 3;
        rotate(nums, rotation);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
