// https://leetcode.com/problems/set-matrix-zeroes/description/

package matrix.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        int colLength = matrix[0].length;
        int rowLength = matrix.length;
        Map<Integer, Boolean> affectedRows = new HashMap<>();
        Map<Integer, Boolean> affectedCol = new HashMap<>();

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (matrix[row][col] == 0) {
                    if (!affectedRows.containsKey(row)) {
                        affectedRows.put(row, false);
                    }
                    if (!affectedCol.containsKey(col)) {
                        affectedCol.put(col, false);
                    }
                }
            }
        }
        for (int row : affectedRows.keySet()) {
            if (!affectedRows.get(row)) {
                affectedRows.put(row, true);
                for (int col = 0; col < colLength; col++) {
                    matrix[row][col] = 0;
                }
            }
        }
        for (int col : affectedCol.keySet()) {
            if (!affectedCol.get(col)) {
                affectedCol.put(col, true);
                for (int row = 0; row < rowLength; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        //int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }
        setZeroes(matrix);
        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }
    }
}
