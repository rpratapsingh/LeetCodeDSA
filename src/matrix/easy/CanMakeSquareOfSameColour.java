// https://leetcode.com/problems/make-a-square-with-the-same-color/description/

package matrix.easy;

public class CanMakeSquareOfSameColour {
    public static boolean canMakeSquare(char[][] grid) {
        int[] white = {0, 0, 0};
        int[] black = {0, 0, 0};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int bCount = convertToNumber(grid[i][j], 'B') + convertToNumber(grid[i][j + 1], 'B') +
                        convertToNumber(grid[i + 1][j], 'B') + convertToNumber(grid[i + 1][j + 1], 'B');
                int wCount = convertToNumber(grid[i][j], 'W') + convertToNumber(grid[i][j + 1], 'W') +
                        convertToNumber(grid[i + 1][j], 'W') + convertToNumber(grid[i + 1][j + 1], 'W');

                if (wCount >= 3 || bCount >= 3) {
                    return true;
                }

            }
        }
        return false;
    }

    public static int convertToNumber(char actual, char expected) {
        if (actual == expected)
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        //char[][] grid = {{'B', 'W', 'B'}, {'B', 'W', 'W'}, {'B', 'W', 'B'}};
        char[][] grid = {{'B', 'W', 'B'}, {'W', 'B', 'W'}, {'B', 'W', 'B'}};
        System.out.println(canMakeSquare(grid));
    }
}
