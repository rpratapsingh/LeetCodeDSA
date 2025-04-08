// https://www.codechef.com/problems/COWA19B

package prefixsum.medium;

import java.util.Scanner;

public class PongalBunk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];
        int[] pArray = new int[arrayLength];
        int numberOfQueries = scanner.nextInt();
        while (numberOfQueries > 0) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            left--;
            right--;
            array[left] += 1;
            if (right + 1 < arrayLength) {
                array[right + 1] -= 1;
                pArray[right + 1] -= (right - left + 1);
            }
            numberOfQueries--;
        }
        for (int i = 1; i < arrayLength; i++) {
            array[i] += array[i - 1];
        }
        pArray[0] = array[0];
        for (int index = 1; index < arrayLength; index++) {
            pArray[index] += pArray[index - 1] + array[index];
        }
        int m = scanner.nextInt();
        while (m > 0) {
            int index = scanner.nextInt();
            System.out.println(array[index]);
            m--;
        }
    }
}
