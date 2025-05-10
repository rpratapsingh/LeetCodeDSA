package arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class IdentifyLargestOutlier {
    public int getLargestOutlier(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            sum += num;
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        int outlier = Integer.MIN_VALUE;
        for (int num : nums) {
            int remaining = sum - num;
            if (remaining % 2 != 0)
                continue;
            int half = remaining / 2;
            int count = frequency.getOrDefault(half, 0);
            if (half != num && count > 0 || (half == num && count > 1)) {
                outlier = Math.max(num, outlier);
            }
        }
        return outlier;
    }
}


class IdentifyLargestOutlierTest {
    public static void main(String[] args) {

    }
}
