// https://leetcode.com/problems/matrix-diagonal-sum/

package matrix.easy;

public class MatrixDiagonalSum {
    public static int diagonalSum(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int finalSum = 0;
        for (int i = 0; i < row; i++) {
            finalSum += mat[i][i];
        }

        for (int i = 0, j = col - 1; i < row && j >= 0; j--, i++) {
            int diff = i - j;
            if (diff != 0) {
                finalSum += mat[i][j];
            }
        }
        return finalSum;
    }

    public static void main(String[] args) {

    }
}
