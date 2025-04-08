// https://leetcode.com/problems/car-pooling/description/

package prefixsum.medium;

public class CarPooling {
    public static boolean carPooling(int[][] trips, int capacity) {
        int maxkm = 0;
        int[] totalKm = new int[1002];
        for (int[] trip : trips) {
            int numberOfPassengers = trip[0];
            if (numberOfPassengers > capacity)
                return false;
            int startPoint = trip[1];
            int endPoint = trip[2];
            totalKm[startPoint] += numberOfPassengers;
            totalKm[endPoint] -= numberOfPassengers;
            if (endPoint > maxkm) {
                maxkm = endPoint;
            }
        }
        for (int index = 1; index <= maxkm; index++) {
            totalKm[index] += totalKm[index - 1];
            if (totalKm[index] > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 5;
        System.out.println(carPooling(trips, capacity));
    }
}
