package arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int index = 0; index < nums.length; index++) {
            if (index > 0 && nums[index] == nums[index - 1]) {
                continue;
            }
            int fixedNumber = nums[index];
            int left = index + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = fixedNumber + nums[left] + nums[right];
                if (currentSum > 0) {
                    right--;
                } else if (currentSum < 0) {
                    left++;
                } else {
                    resultList.add(Arrays.asList(fixedNumber, nums[left], nums[right]));
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
        return resultList;
    }

    public static void main(String[] args) {
        int[] input = {-1,0,1,2,-1,-4};//{-1, 2, 1, -4};
        List<List<Integer>> result = threeSum(input);
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
