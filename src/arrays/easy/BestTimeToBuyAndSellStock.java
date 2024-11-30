// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

package arrays.easy;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int currentMax = 0, globalMax = 0;
        for (int i = 1; i < prices.length; i++) {
            currentMax = Math.max(0, currentMax += prices[i] - prices[i - 1]);
            globalMax = Math.max(currentMax, globalMax);
        }
        return globalMax;
    }


//    Example 1:
//    Input: prices = [7,1,5,3,6,4]
//    Output: 5
//    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

//    Example 2:
//    Input: prices = [7,6,4,3,1]
//    Output: 0
//    Explanation: In this case, no transactions are done and the max profit = 0.

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));

        int[] secondPrices = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(secondPrices));
    }
}
