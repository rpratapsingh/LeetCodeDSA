//https://leetcode.com/problems/majority-element-ii/description/

package hashing.medium;

import java.util.*;

import static utils.AllUtils.toArray;

public class MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
        int majority = nums.length / 3;
        Set<Integer> result = new HashSet<>();
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            if (!frequency.containsKey(num)) {
                frequency.put(num, 0);
            }
            frequency.put(num, frequency.get(num) + 1);
            if (frequency.get(num) > majority) {
                result.add(num);
            }
        }
        return new ArrayList<>(result);
    }

    public static List<Integer> majorityElementNew(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int majority1 = 0, majority2 = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == majority1) {
                count1++;
            } else if (num == majority2) {
                count2++;
            } else if (count1 == 0) {
                majority1 = num;
                count1++;
            } else if (count2 == 0) {
                majority2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == majority1) {
                count1++;
            }
            else if (num == majority2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3)
            result.add(majority1);
        if (count2 > nums.length / 3)
            result.add(majority2);
        return result;
    }

    public static void main(String[] args) {
        int[] input = toArray("[0,0,0]");
        System.out.println(majorityElementNew(input));
    }
}
