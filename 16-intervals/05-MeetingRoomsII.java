// LC 253. Meeting Rooms II
// Approach: Sort start and end times separately. Two pointers. If start < end, need new room.
// Time: O(n log n) | Space: O(n)
import java.util.*;

class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n], ends = new int[n];
        for (int i = 0; i < n; i++) { starts[i] = intervals[i][0]; ends[i] = intervals[i][1]; }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0, endPtr = 0;
        for (int i = 0; i < n; i++) {
            if (starts[i] < ends[endPtr]) rooms++;
            else endPtr++;
        }
        return rooms;
    }
}
