// https://leetcode.com/problems/contains-duplicate/description/

package arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        int ans = 0, lastXOR = Integer.MIN_VALUE;
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            if (count.getOrDefault(num, null) != null) {
                return true;
            } else {
                count.put(num, 0);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] testCase1 = {1, 2, 3, 1};
        System.out.println(containsDuplicate(testCase1));

        int[] testCase2 = {1, 2, 3, 4};
        System.out.println(containsDuplicate(testCase2));

        int[] testCase3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(testCase3));
    }
}
