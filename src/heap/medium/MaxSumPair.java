package heap.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxSumPair {
    public int maximumSum(int[] nums) {

        Map<Integer, Integer> history = new HashMap<>();
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            int digitSum = sumOfDigit(nums[i]);
            if (history.containsKey(digitSum)) {
                int value = history.get(digitSum);
                int sum = value + nums[i];
                if (nums[i] > value) {
                    history.put(digitSum, nums[i]);
                }
                max = Math.max(sum, max);
            } else {
                history.put(digitSum, nums[i]);
            }
        }
        return max;
    }

    private int sumOfDigit(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}

class MaxSumPairTest {
    public static void main(String[] args) {
        int[] input = {229, 398, 269, 317, 420, 464, 491, 218, 439, 153, 482, 169, 411, 93, 147, 50, 347, 210, 251, 366, 401};
        MaxSumPair maxSumPair = new MaxSumPair();
        System.out.println(maxSumPair.maximumSum(input));
    }
}
