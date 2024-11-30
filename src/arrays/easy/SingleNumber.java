// https://leetcode.com/problems/single-number/description/
package arrays.easy;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num; // XOR of same number gives 0 -> 1^1 = 0, 1^0 = 1, 0^0 = 0
            System.out.println(ans + " ans");
        }
        return ans;
    }

    public static void main(String[] args) {
        //int[] num = {2, 2, 1};
        int[] num1 = {4, 1, 2, 1, 2};
        //int[] num2 = {1};
        //System.out.println(singleNumber(num));
        System.out.println(singleNumber(num1));
        //System.out.println(singleNumber(num2));
    }
}
