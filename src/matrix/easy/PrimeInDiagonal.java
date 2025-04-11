// https://leetcode.com/problems/matrix-diagonal-sum/

package matrix.easy;

public class PrimeInDiagonal {
    public static int diagonalPrime(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int largestPrime = 0;
        for (int i = 0; i < row; i++) {
            if (isPrime(mat[i][i]) && largestPrime < mat[i][i]) {
                largestPrime = mat[i][i];
            }
        }

        for (int i = 0, j = col - 1; i < row && j >= 0; j--, i++) {
            int diff = i - j;
            if (diff != 0 && isPrime(mat[i][j]) && largestPrime < mat[i][j]) {
                largestPrime = mat[i][j];
            }
        }
        return largestPrime;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}};
        System.out.println(diagonalPrime(nums));
    }
}
