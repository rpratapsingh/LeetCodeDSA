// https://leetcode.com/problems/remove-element/

package arrays.easy;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pointer++] = nums[i];
            }
        }
        return pointer;
    }

    public static void main(String... args) {
        int[] first = {3, 2, 2, 3};
        System.out.println(removeElement(first, 3));
        print(first);

        int[] second = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println("\n" + removeElement(second, 2));
        print(second);
    }

    public static void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.print("\n");
    }
}
