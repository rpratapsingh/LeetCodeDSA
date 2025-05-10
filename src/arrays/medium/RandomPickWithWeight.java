package arrays.medium;

import java.util.Map;
import java.util.Random;

public class RandomPickWithWeight {

    int[] sum;
    Random rand;
    int totalSum;

    public RandomPickWithWeight(int[] w) {
        sum = new int[w.length];
        sum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            sum[i] = sum[i - 1] + w[i];
        }
        rand = new Random();
        totalSum = sum[sum.length - 1];
    }

    public int pickIndex() {
        int target = rand.nextInt(totalSum) + 1; // range: [1, totalSum]
        System.out.println(target);
        int left = 0, right = sum.length - 1;
        while (left < right) {
            int mid = (left + (right - left)) / 2;
            if (sum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

class RandomPickWithWeightTest {
    public static void main(String[] args) {
        int[] w = {1, 3};
        RandomPickWithWeight withWeight = new RandomPickWithWeight(w);
        System.out.println(withWeight.pickIndex());
    }
}
