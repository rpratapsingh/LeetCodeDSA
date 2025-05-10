package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static utils.AllUtils.to2DArray;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        List<int[]> tempResult = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        stack.push(intervals[0]);
        int currentPointer = 1;
        while (!stack.isEmpty()) {
            if (currentPointer >= intervals.length) {
                tempResult.add(stack.pop());
                continue;
            }
            int[] top = stack.pop();
            int[] next = intervals[currentPointer];
            if (top[1] >= next[0]) {
                if (top[1] > next[1]) {
                    stack.push(new int[]{top[0], top[1]});
                } else {
                    stack.push(new int[]{top[0], next[1]});
                }
            } else {
                tempResult.add(top);
                stack.push(next);
            }
            currentPointer++;
        }
        int[][] result = new int[tempResult.size()][2];
        int i = 0;
        for (int[] interval : tempResult) {
            result[i] = interval;
            i++;
        }
        return result;
    }

    public int[][] merge2(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        List<int[]> tempResult = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] currentMerge = intervals[0];
        int pointer = 1;
        while (pointer < intervals.length) {
            int[] current = intervals[pointer];
            if (currentMerge[1] >= current[0]) {
                int[] newMerge;
                if(currentMerge[1]>current[1]){
                    newMerge = new int[]{currentMerge[0], currentMerge[1]};
                }
                else{
                    newMerge = new int[]{currentMerge[0], current[1]};
                }
                currentMerge = newMerge;
            }
            else{
                tempResult.add(currentMerge);
                currentMerge = current;
            }
            pointer++;
        }
        tempResult.add(currentMerge);

        int[][] result = new int[tempResult.size()][2];
        int i = 0;
        for (int[] interval : tempResult) {
            result[i] = interval;
            i++;
        }
        return result;
    }
}

class MergeIntervalsTest {
    public static void main(String[] args) {
        int[][] intervals = to2DArray("[[1,3],[2,6],[8,10],[15,18]]");
        MergeIntervals mergeIntervals = new MergeIntervals();
        for (int[] entry : mergeIntervals.merge(intervals)) {
            System.out.println(Arrays.toString(entry));
        }

    }
}
