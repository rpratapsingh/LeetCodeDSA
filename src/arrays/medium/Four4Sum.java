// https://leetcode.com/problems/4sum/description/

package arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four4Sum {
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int index = 0; index < nums.length - 3; index++) {
            if (index > 0 && nums[index] == nums[index - 1]) {
                continue;
            }
            long outerFixedNumber = nums[index];
            for (int innerIndex = index + 1; innerIndex < nums.length - 2; innerIndex++) {
                if (innerIndex > index + 1 && nums[innerIndex] == nums[innerIndex - 1]) {
                    continue;
                }
                long fixedNumber = nums[innerIndex];
                int left = innerIndex + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long currentSum = outerFixedNumber + fixedNumber + nums[left] + nums[right];
                    if (currentSum > target) {
                        right--;
                    } else if (currentSum < target) {
                        left++;
                    } else {
                        resultList.add(Arrays.asList(nums[index], nums[innerIndex], nums[left], nums[right]));
                        // Move the left pointer and skip duplicates
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // Move the right pointer and skip duplicates
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                        left++;
                    }
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] input = {1000000000, 1000000000, 1000000000, 1000000000};//{-1, 2, 1, -4};
        int target = -294967296;
        int ij = 1000000000 + 1000000000 + 1000000000 + 1000000000;
        System.out.println(ij);
        List<List<Integer>> result = threeSum(input, target);
        System.out.print("[");
        for (List<Integer> array : result) {
            System.out.print("[");
            for (int i : array) {
                System.out.print(i + ",");
            }
            System.out.print("], ");
        }
        System.out.print("]");
    }
}
