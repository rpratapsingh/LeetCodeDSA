// https://leetcode.com/problems/largest-local-values-in-a-matrix/

package matrix.easy;

public class LargestLocalValuesMatrix {
    public static int[][] largestLocal(int[][] grid) {
        int[][] result = new int[grid.length - 2][grid.length - 2];
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid.length - 2; j++) {
                result[i][j] = getMaxValue(grid, i, j);
            }
        }
        return result;
    }

    static int getMaxValue(int[][] grid, int startRow, int startCol) {
        int max = Integer.MIN_VALUE;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (max < grid[i][j]) {
                    max = grid[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[][] grid = {{1,1,1,1},{1,1,1,1},{1,1,2,1}};//{{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}};//{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}};
        for (int[] n : largestLocal(grid)) {
            for (int num : n) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
