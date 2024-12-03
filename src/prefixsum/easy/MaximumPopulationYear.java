// https://leetcode.com/problems/maximum-population-year/description/

package prefixsum.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MaximumPopulationYear {
    public static int maximumPopulation(int[][] logs) {
        int[] birthRate = new int[101];
        for (int[] year : logs) {
            birthRate[year[0] - 1950] += 1;
            birthRate[year[1] - 1950] -= 1;
        }
        int maxPop = Integer.MIN_VALUE, year = 0;
        for (int index = 0; index < 101 - 1; index++) {
            birthRate[index + 1] += birthRate[index];
        }
        for (int index = 0; index < 101; index++) {
            if (birthRate[index] > maxPop) {
                maxPop = birthRate[index];
                year = index + 1950;
            }
        }

        return year;
    }

    public static void main(String[] args) {
        int[][] logs = {{1950, 1961}, {1960, 1971}, {1970, 1981}};
        System.out.println(maximumPopulation(logs));
    }
}
