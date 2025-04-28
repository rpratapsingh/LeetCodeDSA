// https://leetcode.com/problems/meeting-rooms-ii/description

package heap.medium;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static utils.AllUtils.to2DArray;

public class MeetingRoomsII {
    PriorityQueue<int[]> meetings = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        meetings.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = meetings.poll();
            if (intervals[i][0] >= interval[1]) {
                interval[1] = intervals[i][1];
            } else {
                meetings.offer(intervals[i]);
            }
            meetings.offer(interval);
        }
        return meetings.size();
    }
}

class MeetingRoomsIITest {
    public static void main(String[] args) {
        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
        int[][] intervals = to2DArray("[[0,30],[5,10],[15,20]]");
        System.out.println(meetingRoomsII.minMeetingRooms(intervals));
    }
}
