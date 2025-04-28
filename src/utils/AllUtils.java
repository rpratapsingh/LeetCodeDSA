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

    public static int[] toArray(String input) {
        input = input.substring(1, input.length() - 1);

        // Split by comma
        String[] tokens = input.split(",");

        // Convert to int array
        int[] result = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            result[i] = Integer.parseInt(tokens[i].trim());
        }
        return result;
    }

    public static int[][] to2DArray(String input) {
        // Remove outer brackets
        input = input.replace(" ","");
        input = input.substring(1, input.length() - 1);

        // Split rows
        String[] rows = input.split("],\\[");

        int[][] result = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String row = rows[i].replace("[", "").replace("]", "");
            String[] numbers = row.split(",");
            result[i] = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                result[i][j] = Integer.parseInt(numbers[j].trim());
            }
        }
        return result;
    }

}
