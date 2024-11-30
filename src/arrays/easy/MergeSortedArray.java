// https://leetcode.com/problems/merge-sorted-array/description/

package arrays.easy;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0, j = 0, k = 0;
        int[] result = new int[nums1.length];
        while (i < m && j < n) {
            if (nums1[i] == nums2[j]) {
                result[k++] = nums1[i++];
                result[k++] = nums2[j++];
            } else if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }
        if (i != m) {
            while (i < m) {
                result[k++] = nums1[i++];
            }
        }
        if (j != n) {
            while (j < n) {
                result[k++] = nums2[j++];
            }
        }
        for (int x = 0; x < nums1.length; x++) {
            nums1[x] = result[x];
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] == nums2[j]) {
                nums1[k--] = nums1[i--];
                nums1[k--] = nums2[j--];
            } else if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
        if (i >= 0) {
            while (i >= 0) {
                nums1[k--] = nums1[i--];
            }
        }
        if (j >= 0) {
            while (j >= 0) {
                nums1[k--] = nums2[j--];
            }
        }
//        for (int x = 0; x < nums1.length; x++) {
//            nums1[x] = result[x];
//        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        merge(num1, 3, num2, 3);
        for (int i : num1) {
            System.out.print(i + " ");
        }
    }

}
