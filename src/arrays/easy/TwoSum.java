package arrays.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            if (cache.containsKey(nums[index])) {
                return new int[]{cache.get(nums[index]), index};
            } else {
                cache.put(target - nums[index], index);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
