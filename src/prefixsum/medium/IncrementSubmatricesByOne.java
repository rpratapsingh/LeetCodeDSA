package prefixsum.medium;

import java.util.Arrays;

import static utils.AllUtils.to2DArray;

public class IncrementSubmatricesByOne {

    public static int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];

        for (int[] q : queries) {
            int r1 = q[0], r2 = q[2], c1 = q[1], c2 = q[3];

            for (int r = r1; r <= r2; r++) {
                //increase c1 cell by 1
                mat[r][c1] += 1;
                // decrease by 1 to next c2 cell (c2+1)
                if (c2 + 1 < n) {
                    mat[r][c2 + 1] -= 1;
                }
            }
        }
        // do the sweep
        for (int r = 0; r < n; r++) {
            for (int c = 1; c < n; c++) {
                mat[r][c] += mat[r][c - 1];
            }

        }
        return mat;
    }

    public static void main(String[] args) {

        int[][] queries = to2DArray("[[1,1,2,2],[0,0,1,1]]");
        int[][] result = rangeAddQueries(3, queries);
        for (int[] res : result) {
            System.out.println(Arrays.toString(res));
        }


    }
}
