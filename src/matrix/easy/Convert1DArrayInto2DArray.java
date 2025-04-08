package matrix.easy;

import java.util.Arrays;

public class Convert1DArrayInto2DArray {

    public static int[][] construct2DArray(int[] original, int m, int n) {
        int[][] twoDArray = new int[m][n];
        if (m * n != original.length) {
            return new int[0][0];
        }
        int tempM = 0;
        int tempN = 0;
        for (int index = 0; index < original.length; index++) {
            if (tempN >= n) {
                tempM++;
                tempN = 0;
            }
            twoDArray[tempM][tempN] = original[index];
            tempN++;
        }
        return twoDArray;
    }

    public static void main(String[] args) {
        int[] original = {1, 2};
        int m = 1, n = 1;
        for (int[] array : construct2DArray(original, m, n)) {
            System.out.println(Arrays.toString(array));
        }
    }
}
