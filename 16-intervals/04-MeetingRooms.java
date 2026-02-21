// LC 252. Meeting Rooms
// Approach: Sort by start time. Check if any adjacent pair overlaps.
// Time: O(n log n) | Space: O(1)
import java.util.*;

class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        return true;
    }
}
