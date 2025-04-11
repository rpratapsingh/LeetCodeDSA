// https://leetcode.com/problems/richest-customer-wealth/

package matrix.easy;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {

        int customer = accounts.length;
        int bank = accounts[0].length;
        int maxBalance = 0;
        for (int i = 0; i < customer; i++) {
            int balance = 0;
            for (int j = 0; j < bank; j++) {
                balance += accounts[i][j];
            }
            if (balance > maxBalance) {
                maxBalance = balance;
            }
        }
        return maxBalance;
    }
}
