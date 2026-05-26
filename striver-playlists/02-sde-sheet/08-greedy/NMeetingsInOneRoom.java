/*
 * Problem: N Meetings in One Room — max meetings that can fit without overlap.
 *
 * Intuition: Sort by end time; pick a meeting if its start > last picked end.
 * Time: O(n log n)  Space: O(n)
 */
import java.util.*;
public class NMeetingsInOneRoom {
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> end[a] - end[b]);
        int cnt = 1, last = end[idx[0]];
        for (int i = 1; i < n; i++) {
            if (start[idx[i]] > last) { cnt++; last = end[idx[i]]; }
        }
        return cnt;
    }
}
