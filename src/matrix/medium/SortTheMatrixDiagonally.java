// https://leetcode.com/problems/sort-the-matrix-diagonally/description/

package matrix.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortTheMatrixDiagonally {
    public static int[][] diagonalSort(int[][] mat) {
        int rowLength = mat.length;
        int colLength = mat[0].length;
        for (int row = rowLength - 1; row >= 0; row--) {
            int i = row, j = 0;
            List<Integer> newList = new ArrayList<>();
            while (i < rowLength && j < colLength) {
                System.out.print(mat[i][j] + "(" + i + "," + j + ")   ");
                newList.add(mat[i][j]);
                i++;
                j++;
            }
            System.out.println();
            Collections.sort(newList);
            i = row;
            j = 0;
            int k = 0;
            while (i < rowLength && j < colLength) {
                mat[i][j] = newList.get(k);
                k++;
                i++;
                j++;
            }
        }
        for (int col = 1; col < colLength; col++) {
            int i = 0, j = col;
            List<Integer> newList = new ArrayList<>();
            while (i < rowLength && j < colLength) {
                System.out.print(mat[i][j] + "(" + i + "," + j + ")   ");
                newList.add(mat[i][j]);
                i++;
                j++;
            }
            System.out.println();
            Collections.sort(newList);
            i = 0;
            j = col;
            int k = 0;
            while (i < rowLength && j < colLength) {
                mat[i][j] = newList.get(k);
                i++;
                j++;
                k++;
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        //int[][] matrix = {{11, 25, 66, 1, 69}, {55, 17, 45, 15, 52}, {31, 36, 44, 58, 8}, {27, 33, 25, 68, 4}, {28, 14, 11, 5, 50}};
        int[][] matrix = {{11, 25, 66, 1, 69, 7}, {23, 55, 17, 45, 15, 52}, {75, 31, 36, 44, 58, 8}, {22, 27, 33, 25, 68, 4}, {84, 28, 14, 11, 5, 50}};
        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }
        for (int[] array : diagonalSort(matrix)) {
            System.out.println(Arrays.toString(array));
        }
    }
}
