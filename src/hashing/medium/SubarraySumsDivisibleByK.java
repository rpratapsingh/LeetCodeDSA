// https://leetcode.com/problems/subarray-sums-divisible-by-k/description/

package hashing.medium;

import static utils.AllUtils.toArray;

public class SubarraySumsDivisibleByK {
    public static int subarraysDivByK(int[] nums, int k) {

        int prefixMod = 0;
        int[] modGroup = new int[k];
        modGroup[0] = 1;
        int count = 0;
        for (int num : nums) {
            prefixMod = (prefixMod + num % k + k) % k;
            count += modGroup[prefixMod];
            modGroup[prefixMod]++;
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = toArray("[4,5,0,-2,-3,1]");
        int k = 5;
        System.out.println(subarraysDivByK(nums, k));
    }
}
