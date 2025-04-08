// https://leetcode.com/problems/my-calendar-ii/description/

package prefixsum.medium;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarII {

    Map<Integer, Integer> timeSlots;

    public MyCalendarII() {
        timeSlots = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        int startTimeMeetingCount = timeSlots.getOrDefault(startTime, 0);
        int endTimeMeetingCount = timeSlots.getOrDefault(endTime, 0);
        timeSlots.put(startTime, startTimeMeetingCount + 1);
        timeSlots.put(endTime, endTimeMeetingCount - 1);
        int currentMeetingCount = 0;
        for (int meetingCounts : timeSlots.values()) {
            currentMeetingCount += meetingCounts;
            if (currentMeetingCount > 2) {
                timeSlots.put(startTime, startTimeMeetingCount);
                if (startTimeMeetingCount == 0) {
                    timeSlots.remove(startTime);
                }
                timeSlots.put(endTime, endTimeMeetingCount);
                if (endTimeMeetingCount == 0) {
                    timeSlots.remove(endTime);
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MyCalendarII myCalendarTwo = new MyCalendarII();
        System.out.println(myCalendarTwo.book(10, 20)); // return True, The event can be booked.
        System.out.println(myCalendarTwo.book(50, 60)); // return True, The event can be booked.
        System.out.println(myCalendarTwo.book(10, 40)); // return True, The event can be double booked.
        System.out.println(myCalendarTwo.book(5, 15));  // return False, The event cannot be booked, because it would result in a triple booking.
        System.out.println(myCalendarTwo.book(5, 10)); // return True, The event can be booked, as it does not use time 10 which is already double booked.
        System.out.println(myCalendarTwo.book(25, 55)); // return True, The event can be booked, as the time in [25, 40) will be double booked with the third event, the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
    }
}
