// https://leetcode.com/problems/check-if-matrix-is-x-matrix/description/

package matrix.easy;

public class CheckIfMatrixIsXMatrix {
    public static boolean checkXMatrix(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean isOnDiagonal = isOnDiagonal(i, j, rows - 1);
                if (isOnDiagonal) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isOnDiagonal(int i, int j, int length) {
        int diff = Math.abs(i - j);
        int sum = i + j;
        if (diff == 0 || sum == length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //int[][] input = {{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}};
        int[][] input = {{5, 7, 0}, {0, 3, 1}, {0, 5, 0}};
        System.out.println(checkXMatrix(input));
    }
}
