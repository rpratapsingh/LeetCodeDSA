package arrays.easy;

public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] nums) {

        int length = nums.length;
        int oddPointer = 0;
        int runningPointer = 0;
        while (runningPointer < length) {
            if (nums[runningPointer] % 2 == 0) {
                int temp = nums[runningPointer];
                nums[runningPointer] = nums[oddPointer];
                nums[oddPointer] = temp;
                runningPointer++;
                oddPointer++;
            }
            else{
                runningPointer++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] array = {2, 3,6, 1, 2, 4,5};
        sortArrayByParity(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
