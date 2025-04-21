// https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/

package slidingwindow.medium;

import static utils.AllUtils.toArray;

public class SubArraysAverageGreaterThreshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int length = arr.length, r = 0, l = 0, sum = 0, count = 0;
        while (r < length) {
            sum += arr[r];
            if (r - l + 1 >= k) {
                if (sum / k >= threshold) {
                    count++;
                }
                sum -= arr[l];
                l++;
            }
            r++;
        }
        return count;
    }


    public static void main(String[] args) {
        SubArraysAverageGreaterThreshold ss = new SubArraysAverageGreaterThreshold();
        int[] arr = toArray("[11,13,17,23,29,31,7,5,2,3]");
        int k = 3, threshold = 5;
        System.out.println(ss.numOfSubarrays(arr, k, threshold));
    }
}
