// https://leetcode.com/problems/points-that-intersect-with-cars/description/

package prefixsum.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PointsThatIntersectWithCars {
    public static int numberOfPoints(List<List<Integer>> nums) {
        int[] intersection = new int[101];
        for (List<Integer> points : nums) {
            for (int index = points.get(0); index <= points.get(1); index++) {
                intersection[index] = 1;
            }
        }
        int streakCount = 0;
        for (int num : intersection) {
            if (num != 0) {
                streakCount += 1;
            }
        }
        return streakCount;
    }

    public static int numberOfPointsII(List<List<Integer>> nums) {
        int[] intersection = new int[101];
        for (List<Integer> points : nums) {
            intersection[points.get(0)]++;
            intersection[points.get(1) + 1]--;
        }
        int streakCount = 0;
        int sum = 0;
        for (int index = 1; index < 101; index++) {
            sum += intersection[index];
            if (sum != 0) {
                streakCount += 1;
            }
        }
        return streakCount;
    }

    public static void main(String[] args) {
        List<List<Integer>> points = new ArrayList<>();
        points.add(Arrays.asList(3, 6));
        points.add(Arrays.asList(1, 5));
        points.add(Arrays.asList(4, 7));
        System.out.println(numberOfPointsII(points));
    }
}
