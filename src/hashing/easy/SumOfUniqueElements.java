// https://leetcode.com/problems/sum-of-unique-elements/description/

package hashing.easy;

import java.util.HashMap;
import java.util.Map;

import static utils.AllUtils.toArray;

public class SumOfUniqueElements {

    public static int sumOfUnique(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> track = new HashMap<>();
        for (int num : nums) {
            Integer value = track.get(num);
            if (value != null && value == 1) {
                sum -= num;
            } else {
                if (value == null) {
                    sum += num;
                }
            }
            track.put(num, track.getOrDefault(num, 0) + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfUnique(toArray("1,2,3,2")));
        System.out.println(sumOfUnique(toArray("1,1,1,1,1")));
        System.out.println(sumOfUnique(toArray("1,2,3,4,5")));
    }
}
