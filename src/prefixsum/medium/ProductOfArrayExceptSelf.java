// https://leetcode.com/problems/product-of-array-except-self/description/

package prefixsum.medium;

import java.util.Arrays;

import static utils.AllUtils.toArray;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf1(int[] nums) {
        int[] result = new int[nums.length];
        int zeroCount = 0;
        int zeroIndex = -1;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                zeroIndex = i;
                if (zeroCount > 1) {
                    return result;
                }
                continue;
            }
            product *= nums[i];
        }
        if (zeroCount != 0) {
            result[zeroIndex] = product;
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = product / nums[i];
        }
        return result;
    }


    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        ans[0] = 1;
        // Calculate prefix products
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int prevSuffix = 1;
        // Calculate suffix products and update ans array
        for (int i = n - 2; i >= 0; i--) {
            prevSuffix *= nums[i + 1];
            ans[i] *= prevSuffix;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] input = toArray("1,2,3,4");
        int[] input1 = toArray("-1,1,0,-3,3");
        System.out.println(Arrays.toString(productExceptSelf(input)));
        System.out.println(Arrays.toString(productExceptSelf(input1)));
    }
}
