// https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/

package arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllKDistantIndicesInAnArray {

    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        List<Integer> keyIndex = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                keyIndex.add(i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int selectedKey : keyIndex) {
                if (Math.abs(i - selectedKey) <= k) {
                    result.add(i);
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 9, 1, 3, 9, 5};
        int key = 9, k = 1;
        List<Integer> result = findKDistantIndices(nums, key, k);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
