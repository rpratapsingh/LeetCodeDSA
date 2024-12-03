// https://leetcode.com/problems/find-good-days-to-rob-the-bank/description/

package prefixsum.medium;

import java.util.ArrayList;
import java.util.List;

public class FindGoodDaysToRobTheBank {

    public static List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        List<Integer> result = new ArrayList<>();

        // Arrays to track non-increasing and non-decreasing counts
        int[] nonIncreasing = new int[n];
        int[] nonDecreasing = new int[n];

        // Compute nonIncreasing array
        for (int i = 1, j = n - 2; i < n; i++, j--) {
            if (security[i] <= security[i - 1]) {
                nonIncreasing[i] = nonIncreasing[i - 1] + 1;
            }
            if (security[j] <= security[j + 1]) {
                nonDecreasing[j] = nonDecreasing[j + 1] + 1;
            }
        }

        // Check for good days
        for (int i = time; i < n - time; i++) {
            if (nonIncreasing[i] >= time && nonDecreasing[i] >= time) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] security = {5, 3, 3, 3, 5, 6, 2};
        int time = 2;
        System.out.println(goodDaysToRobBank(security, time).toString());
    }
}
