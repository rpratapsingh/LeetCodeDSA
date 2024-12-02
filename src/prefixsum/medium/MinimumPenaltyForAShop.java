// https://leetcode.com/problems/minimum-penalty-for-a-shop/description/

package prefixsum.medium;

public class MinimumPenaltyForAShop {
    public static int bestClosingTime(String customers) {
        int length = customers.length();
        int[] prefixSum = new int[length + 1];
        int[] suffixSum = new int[length + 1];
        char[] letters = customers.toCharArray();

        int penaltyCount = 0;
        for (int start = 0, end = length - 1; start < length; start++, end--) {
            prefixSum[start + 1] = prefixSum[start] + (letters[start] == 'N' ? 1 : 0);
            suffixSum[end] = suffixSum[end + 1] + (letters[end] == 'Y' ? 1 : 0);
        }

        int minPenalty = Integer.MAX_VALUE;
        int bestHour = -1;
        for (int start = 0; start <= length; start++) {
            int penalty = prefixSum[start] + suffixSum[start];
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = start;
            }
        }
        return bestHour;
    }

    public static void main(String[] args) {

        String customers = "YYNY";
        System.out.println(bestClosingTime(customers));
    }
}
