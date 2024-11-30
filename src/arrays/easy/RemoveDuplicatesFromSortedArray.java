// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

package arrays.easy;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {

        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[pointer] == nums[i]) {
                continue;
            } else {
                nums[++pointer] = nums[i];
            }
        }
        return pointer + 1;
    }

    public static void main(String... args) {
        int[] first = {1, 1, 2};
        System.out.println(removeDuplicates(first));
        print(first);

        int[] second = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("\n" + removeDuplicates(second));
        print(second);
    }

    public static void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }


}
