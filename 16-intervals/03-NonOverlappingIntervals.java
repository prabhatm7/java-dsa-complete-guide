// LC 435. Non-overlapping Intervals
// Approach: Sort by end time. Greedily keep intervals that end earliest (activity selection).
// Count removals when overlap detected.
// Time: O(n log n) | Space: O(1)
import java.util.*;

class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 0, prevEnd = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] >= prevEnd)
                prevEnd = interval[1];
            else
                count++;
        }
        return count;
    }
}
