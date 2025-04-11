//https://leetcode.com/problems/row-with-maximum-ones/

package matrix.easy;

public class RowWithMaximumOne {

    public static int[] rowAndMaximumOnes(int[][] mat) {
        int[] returnArray = {0, 0};
        int rows = mat.length;
        int cols = mat[1].length;
        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    sum++;
                }
            }
            if (sum > returnArray[1]) {
                returnArray[0] = i;
                returnArray[1] = sum;
            }
        }
        return returnArray;
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 1}, {1, 0}};
        int[] result = rowAndMaximumOnes(mat);
        for (int number : result) {
            System.out.println(number);
        }

    }
}
