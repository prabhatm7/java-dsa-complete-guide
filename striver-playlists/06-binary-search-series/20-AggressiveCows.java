/*
 * Problem: Aggressive Cows — place k cows so min distance is maximized.
 *
 * Intuition: Sort; BS on answer; greedily place.
 * Time: O(n log range)  Space: O(1)
 */
import java.util.*;
public class AggressiveCows {
    public int solve(int[] s, int k) {
        Arrays.sort(s);
        int lo = 1, hi = s[s.length - 1] - s[0];
        while (lo <= hi) {
            int m = (lo + hi) >>> 1;
            if (can(s, k, m)) lo = m + 1; else hi = m - 1;
        }
        return hi;
    }
    private boolean can(int[] s, int k, int d) {
        int cnt = 1, last = s[0];
        for (int i = 1; i < s.length; i++)
            if (s[i] - last >= d) { cnt++; last = s[i]; if (cnt >= k) return true; }
        return false;
    }
}
