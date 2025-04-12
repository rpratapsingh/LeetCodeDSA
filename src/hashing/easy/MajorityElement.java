// https://leetcode.com/problems/majority-element/description/

package hashing.easy;

import static utils.AllUtils.toArray;

public class MajorityElement {
    public static int majorityElement(int[] nums) {

        int majority = 0;
        int element = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (majority == 0)
                element = nums[i];
            majority += element == nums[i] ? 1 : -1;
        }
        return element;
    }


    public static void main(String[] args) {
        int[] input = toArray("[3,2,3]");
        System.out.println(majorityElement(input));
    }
}
