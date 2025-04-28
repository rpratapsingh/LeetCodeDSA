package dynamic.medium;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {

        int max = 0;
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            max += num;
            if (max > result)
                result = max;
            if (max < 0) {
                max = 0;
            }
        }
        return result;
    }

}

class MaximumSubArrayTest {
    public static void main(String[] args) {
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        System.out.println(maximumSubArray.maxSubArray(input));
    }
}
