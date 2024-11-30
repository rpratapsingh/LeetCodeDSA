// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/

package arrays.easy;

public class IntersectionOfTwoArraysII {
    public static int[] intersect(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        int size = 0;
        int[] intersection = new int[length1 > length2 ? length2 : length1];
        if (length2 > length1) {
            int position = 0;
            for (int i = 0; i < length1; i++) {
                for (int j = 0; j < length2; j++) {
                    if (nums1[i] == nums2[j]) {
                        intersection[position++] = nums1[i];
                        nums2[j] = -1;
                        size++;
                        break;
                    }
                }
            }
        } else {
            int position = 0;
            for (int i = 0; i < length2; i++) {
                for (int j = 0; j < length1; j++) {
                    if (nums2[i] == nums1[j]) {
                        intersection[position++] = nums2[i];
                        nums1[j] = -1;
                        size++;
                        break;
                    }
                }
            }
        }

        int[] finalArray = new int[size];
        for (int i = 0; i < size; i++) {
            finalArray[i] = intersection[i];
        }
        return finalArray;
    }

    public static void main(String[] args) {
        int[] first = {1, 2, 2, 1}, second = {2, 2};
        for (int number : intersect(first, second)) {
            System.out.print(number + " ");
        }
        System.out.println("");

        int[] first1 = {4, 9, 5}, second1 = {9, 4, 9, 8, 4};
        for (int number : intersect(first1, second1)) {
            System.out.print(number + " ");
        }
    }
}
