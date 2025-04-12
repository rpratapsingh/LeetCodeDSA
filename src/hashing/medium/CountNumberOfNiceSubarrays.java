// https://leetcode.com/problems/count-number-of-nice-subarrays/description/

package hashing.medium;

import java.util.HashMap;
import java.util.Map;

import static utils.AllUtils.toArray;

public class CountNumberOfNiceSubarrays {
    public static int numberOfSubarrays(int[] nums, int k) {
        int count = 0, currentSum = 0;
        int[] prefixSum = new int[50000];
        //Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum[0] = 1;
        for (int num : nums) {
            currentSum += num % 2;
            count += prefixSum[currentSum - k];
            prefixSum[currentSum]++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = toArray("[1,1,2,1,1]");
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k));
    }
}
