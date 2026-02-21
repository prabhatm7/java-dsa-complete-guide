// LC 56. Merge Intervals
// Approach: Sort by start. If current overlaps with last in result, extend end. Else add new.
// Time: O(n log n) | Space: O(n)
import java.util.*;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (!res.isEmpty() && res.get(res.size() - 1)[1] >= interval[0])
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], interval[1]);
            else
                res.add(interval);
        }
        return res.toArray(new int[res.size()][]);
    }
}
