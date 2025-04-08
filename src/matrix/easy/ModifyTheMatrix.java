// https://leetcode.com/problems/modify-the-matrix/description/

package matrix.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModifyTheMatrix {
    public static int[][] modifiedMatrix(int[][] matrix) {
        int rows = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < column; i++) {
            int maxElement = -1;
            int maxElementIndex = -1;
            List<Integer> negativeElementIndex = new ArrayList<>();
            for (int j = 0; j < rows; j++) {
                if (matrix[j][i] == -1) {
                    negativeElementIndex.add(j);
                }
                if (matrix[j][i] > maxElement) {
                    maxElement = matrix[j][i];
                    maxElementIndex = j;
                }
            }
            if (!negativeElementIndex.isEmpty()) {
                for (int negativeIndex : negativeElementIndex)
                    matrix[negativeIndex][i] = matrix[maxElementIndex][i];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        //Input: matrix = [[1,2,-1],[4,-1,6],[7,8,9]]
        //Output: [[1,2,9],[4,8,6],[7,8,9]]

        int[][] original = {{-1, 0, 0, 2, 2}, {2, 0, 0, 2, 1}, {4, 3, 2, 1, 1}, {-1, -1, 0, 2, 4}, {1, 0, 3, -1, 0}};
        for (int[] array : original) {
            System.out.println(Arrays.toString(array));
        }
        System.out.println("After");
        for (int[] array : modifiedMatrix(original)) {
            System.out.println(Arrays.toString(array));
        }
    }
}
