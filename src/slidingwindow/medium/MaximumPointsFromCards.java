// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

package slidingwindow.medium;

import java.util.Arrays;

import static utils.AllUtils.toArray;

public class MaximumPointsFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int length = cardPoints.length;
        int forwardSum = 0;
        for (int i = 0; i < k; i++) {
            forwardSum += cardPoints[i];
        }
        int start = k - 2, end = length - 1, backwordSum = 0, max = forwardSum;
        for (int i = 0; i < k; i++) {
            int totalSum = 0;
            backwordSum += end < length ? cardPoints[end] : 0;
            forwardSum = forwardSum - cardPoints[start + 1];
            totalSum = backwordSum+ forwardSum;
            if (totalSum > max) {
                max = totalSum;
            }
            end--;
            start--;
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumPointsFromCards max = new MaximumPointsFromCards();
        System.out.println(max.maxScore(toArray("[1,2,3,4,5,6,1]"), 3));
    }
}
