/*
 * Problem: Activity Selection — same as N meetings problem.
 *
 * Intuition: Sort by finish time; greedily pick first compatible activity.
 * Time: O(n log n)  Space: O(1)
 */
import java.util.*;
public class ActivitySelection {
    public int select(int[] start, int[] finish) {
        int n = start.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> finish[a] - finish[b]);
        int cnt = 1, last = finish[idx[0]];
        for (int i = 1; i < n; i++) if (start[idx[i]] >= last) { cnt++; last = finish[idx[i]]; }
        return cnt;
    }
}
