// https://leetcode.com/problems/apply-operations-to-an-array/description/

package arrays.easy;

public class ApplyOperationsToAnArray {
    public static int[] applyOperations(int[] nums) {
        for (int index = 0; index < nums.length - 1; index++) {
            if (nums[index] == nums[index + 1]) {
                nums[index] *= 2;
                nums[index + 1] = 0;
            }
        }

        int[] result = new int[nums.length];
        int start = 0, end = nums.length - 1;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != 0) {
                result[start++] = nums[index];
            } else {
                result[end--] = nums[index];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 1 4 0 2 0 0
        // [1,4,2,0,0,0]
         int[] nums = {1, 2, 2, 1, 1, 0};
        //int[] nums = {0, 1};
        int[] result = applyOperations(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
