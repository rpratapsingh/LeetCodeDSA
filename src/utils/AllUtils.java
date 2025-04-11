package utils;

import java.util.Arrays;

public class AllUtils {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(array.toString() + " ");
        }
        System.out.println();
    }

    public static <T> void printArray(T[][] array) {
        for (T[] elements : array) {
            printArray(elements);
        }
        System.out.println();
    }

    public static int[] toArray(String string) {
        String[] array = string.split(",");
        int[] intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }
        return intArray;
    }
}
