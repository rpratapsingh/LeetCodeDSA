package stack.medium;

import static utils.AllUtils.to2DArray;

public class InsertInterval {


    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (newStart <= end && newEnd >= end) {
                System.out.println("merge " + newStart + " " + +interval[0] + " " + interval[1]);
            }
            if (newStart <= end && newEnd >= end) {
                System.out.println("merge " + newStart + " " + +interval[0] + " " + interval[1]);
            }
            //System.out.println(interval[0] + " " + interval[1]);
        }
        return null;
    }
}


class InsertIntervalTest {
    public static void main(String[] args) {
        int[][] intervals = to2DArray("[1,3],[6,9]]");
        int[] newInterval = {2, 6};
        InsertInterval interval = new InsertInterval();
        interval.insert(intervals, newInterval);
    }
}
