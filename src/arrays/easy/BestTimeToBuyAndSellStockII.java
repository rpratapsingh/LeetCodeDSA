// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

package arrays.easy;

public class BestTimeToBuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit > 0 ? maxProfit : 0;
    }


    public static void main(String[] args) {
        int[][] pricesList = {{7, 1, 5, 3, 6, 4}, {1, 2, 3, 4, 5}, {7, 6, 4, 3, 1}};
        for (int[] prices : pricesList) {
            System.out.println(maxProfit(prices));
        }
    }
}
