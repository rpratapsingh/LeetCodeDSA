// https://leetcode.com/problems/contains-duplicate/description/

package hashing.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static utils.AllUtils.toArray;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for (int number : nums) {
            if (!elements.add(number)) {
                return true;
            }
            elements.add(number);
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(containsDuplicate(toArray("1,2,3,4")));
    }
}
