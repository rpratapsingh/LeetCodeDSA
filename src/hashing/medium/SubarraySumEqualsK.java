// https://leetcode.com/problems/subarray-sum-equals-k/description/
package hashing.medium;

import java.util.HashMap;
import java.util.Map;

import static utils.AllUtils.toArray;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> subsequentSumFrequency = new HashMap<>();
        subsequentSumFrequency.put(0, 1);
        int count = 0, total = 0;
        for (int num : nums) {
            total += num;
            count += subsequentSumFrequency.getOrDefault(total - k, 0);
            subsequentSumFrequency.put(total, subsequentSumFrequency.getOrDefault(total, 0) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        int[] input = toArray("[1,2,3]");
        System.out.println(subarraySum(input, 3));
    }
}
