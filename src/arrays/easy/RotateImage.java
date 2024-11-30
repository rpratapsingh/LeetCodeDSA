package arrays.easy;

public class RotateImage {
    public static void rotate(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        print(matrix);
        for (int i = 0; i < matrix.length; i++) {
            int start = 0;
            int end = matrix[i].length - 1;
            while (start < end) {
                // Swap the elements at the start and end of the row
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;

                // Move towards the middle of the row
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] testCase = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //int[][] testCase = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        //int[][] testCase = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
        print(testCase);
        rotate(testCase);
        print(testCase);
    }

    private static void print(int[][] matrix) {
        for (int[] numbers : matrix) {
            for (int number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
