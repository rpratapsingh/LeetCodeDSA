package prefixsum.medium;

public class RangeSumQuery2DImmutable {

    int[][] dp;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        System.out.println(dp[row2 + 1][col2 + 1] + " " + dp[row1][col2 + 1] + " " + dp[row2 + 1][col1] + " " + dp[row1][col1]);
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        RangeSumQuery2DImmutable s = new RangeSumQuery2DImmutable(matrix);
        System.out.println(s.sumRegion(2, 1, 4, 3));
        System.out.println(s.sumRegion(1, 1, 2, 2));
        System.out.println(s.sumRegion(1, 2, 2, 4));
    }
}
