package heap.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static utils.AllUtils.to2DArray;

public class TwoBestNonOverlappingEvents {
    int size;

    public int maxTwoEvents(int[][] events) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int ans = 0, max = 0;
        for (int[] event : events) {
            while (!queue.isEmpty() && queue.peek()[0] < event[0]) {
                max = Math.max(max, queue.poll()[1]);
            }
            ans = Math.max(ans, max + event[2]);
            queue.offer(new int[]{event[1], event[2]});
        }
        return ans;
    }

    int[][] memory = new int[1000001][3];

    private int binarySearch(int[][] events, int endTime) {
        int l = 0;
        int r = size - 1;
        int result = size;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (events[mid][0] > endTime) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

    private int solve(int[][] events, int index, int count) {
        if (count == 2 || index >= size) {
            return 0;
        }
        if (memory[index][count] != -1) {
            return memory[index][count];
        }
        int nextValidIndex = binarySearch(events, events[index][1]);
        int take = events[index][2] + solve(events, nextValidIndex, count + 1);
        int notTake = solve(events, index + 1, count);
        memory[index][count] = Math.max(take, notTake);
        return Math.max(take, notTake);
    }

    public int maxTwoEvents2(int[][] events) {
        for (int i = 0; i < 1000001; i++) {
            for (int j = 0; j < 3; j++) {
                memory[i][j] = -1;
            }
        }
        size = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int count = 0;
        return solve(events, 0, count);
    }
}

class TwoBestNonOverlappingEventsTest {

    public static void main(String[] args) {
        int[][] input = to2DArray("[[4,4,3],[2,4,2],[1,4,3],[3,3,1]]");
        TwoBestNonOverlappingEvents twoBestNonOverlappingEvents = new TwoBestNonOverlappingEvents();
        System.out.println(twoBestNonOverlappingEvents.maxTwoEvents2(input));
    }
}
