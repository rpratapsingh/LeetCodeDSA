package arrays.medium;

import java.util.Arrays;

public class Three3SumClosest {
    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int closestNumber = Integer.MAX_VALUE;
        int result = 0;

        for (int index = 0; index < nums.length; index++) {
            int fixedNumber = nums[index];
            int left = index + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = fixedNumber + nums[left] + nums[right];
                if (Math.abs(target - closestNumber) > Math.abs(target - currentSum)) {
                    closestNumber = currentSum;
                    result = currentSum;
                }
                if (currentSum > target) {
                    right--;
                } else if (currentSum < target) {
                    left++;
                } else {
                    return currentSum;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {4, 0, 5, -5, 3, 3, 0, -4, -5};//{-1, 2, 1, -4};
        int target = -2;
        int result = threeSumClosest(array, target);
        System.out.println(result);
    }
}
