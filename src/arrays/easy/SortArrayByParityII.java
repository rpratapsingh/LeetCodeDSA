package arrays.easy;

public class SortArrayByParityII {
    public static int[] sortArrayByParityII(int[] nums) {

        int[] sortedArray = new int[nums.length];
        int evenPointer = 0;
        int oddPointer = 1;
        for (int number : nums) {
            if (number % 2 == 0) {
                sortedArray[evenPointer] = number;
                evenPointer += 2;
            } else {
                sortedArray[oddPointer] = number;
                oddPointer += 2;
            }
        }
        return sortedArray;
    }

    public static int[] sortArrayByParityII2(int[] a) {
        int i = 0; //pointer for even misplaced
        int j = 1; //pointer for odd misplaced
        int sz = a.length;

        /*** invariant:
         for every misplaced odd there is misplaced even
         since there is just enough space for odds and evens */

        while (i < sz && j < sz) {
            if (a[i] % 2 == 0)
                i += 2;
            else if (a[j] % 2 == 1)
                j += 2;
            else {
                // a[i] % 2 == 1 AND a[ j] %2 == 0
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i += 2;
                j += 2;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] array = {2, 0, 3, 4, 1, 3};
        int[] sortedArray = sortArrayByParityII2(array);
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
    }
}
