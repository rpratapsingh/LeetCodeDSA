// https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/
package matrix.easy;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumberInMatrix {
    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int[] minLst = new int[matrix.length];
        for (int i = 0; i < minLst.length; i++) {
            minLst[i] = Integer.MAX_VALUE;
        }
        int[] maxList = new int[matrix[0].length];
        for (int i = 0; i < maxList.length; i++) {
            maxList[i] = Integer.MIN_VALUE;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < minLst[i]) {
                    minLst[i] = matrix[i][j];
                }
                if (matrix[i][j] > maxList[j]) {
                    maxList[j] = matrix[i][j];
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (minLst[i] == maxList[j]) {
                    result.add(minLst[i]);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        System.out.println(luckyNumbers(matrix));
    }
}
