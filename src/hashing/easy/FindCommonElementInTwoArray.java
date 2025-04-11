// https://leetcode.com/problems/find-common-elements-between-two-arrays/description/
package hashing.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindCommonElementInTwoArray {
    public static int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] answer = new int[2];
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            hash.put(nums1[i], 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (hash.containsKey(nums2[i])) {
                answer[1]++;
            }
        }
        hash.clear();

        for (int i = 0; i < nums2.length; i++) {
            hash.put(nums2[i], 1);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (hash.containsKey(nums1[i])) {
                answer[0]++;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] nums1 = {2, 3, 2}, nums2 = {1, 2};
        int[] result = findIntersectionValues(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
