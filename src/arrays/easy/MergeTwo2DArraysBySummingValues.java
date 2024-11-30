// https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/description/

package arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class MergeTwo2DArraysBySummingValues {
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();
//        int[][] num1 = {{2, 4}, {3, 6}, {5, 5}};
//        int[][] num2 = {{1, 3}, {4, 3}};
        while (i < length1 && j < length2) {
            int[] subNum1 = nums1[i];
            int[] subNum2 = nums2[j];
            if (subNum1[0] == subNum2[0]) {
                int[] node = {subNum1[0], subNum1[1] + subNum2[1]};
                list.add(node);
                i++;
                j++;
            } else if (subNum1[0] > subNum2[0]) {
                int[] node = subNum2;
                list.add(node);
                j++;
            } else {
                int[] node = subNum1;
                list.add(node);
                i++;
            }
        }

        if (i != length1) {
            while (i < length1) {
                list.add(nums1[i]);
                i++;
            }
        }
        if (j != length2) {
            while (j < length2) {
                list.add(nums2[j]);
                j++;
            }
        }

        int[][] finalList = new int[list.size()][2];
        i = 0;
        for (int[] node : list) {
            finalList[i] = node;
            i++;
        }
        return finalList;
    }

    public static void main(String[] args) {
        int[][] num1 = {{2, 4}, {3, 6}, {5, 5}};
        int[][] num2 = {{1, 3}, {4, 3}};
        int[][] list = mergeArrays(num1, num2);
        System.out.print("[");
        for (int[] array : list) {
            System.out.print("[");
            for (int i : array) {
                System.out.print(i + ",");
            }
            System.out.print("], ");
        }
        System.out.print("]");

    }
}
