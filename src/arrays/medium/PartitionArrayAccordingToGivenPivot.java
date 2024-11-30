// https://leetcode.com/problems/partition-array-according-to-given-pivot/description/

package arrays.medium;

public class PartitionArrayAccordingToGivenPivot {

    public static int[] pivotArray(int[] nums, int pivot) {

        int[] result = new int[nums.length];
        int smallNumbers = 0, same = 0;
        for (int number : nums) {
            if (number < pivot)
                smallNumbers++;
            else if (number == pivot)
                same++;
        }

        int before = 0, after = smallNumbers + same;
        for (int number : nums) {
            if (number < pivot) {
                result[before++] = number;
            } else if(number > pivot){
                result[after++] = number;
            }
        }
        while(same>0) {
            result[smallNumbers++] = pivot;
            same--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;
        int[] result = pivotArray(nums, pivot);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
