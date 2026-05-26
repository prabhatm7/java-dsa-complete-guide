/*
 * Problem: Aggressive Cows — place k cows in stalls so min distance is maximized.
 *
 * Intuition: Sort positions; BS on answer (distance); check if k cows fit with this min gap greedily.
 * Time: O(n log n + n log range)  Space: O(1)
 */
import java.util.*;
public class AggressiveCows {
    public int solve(int[] stalls, int k) {
        Arrays.sort(stalls);
        int lo = 1, hi = stalls[stalls.length - 1] - stalls[0];
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (canPlace(stalls, k, mid)) lo = mid + 1; else hi = mid - 1;
        }
        return hi;
    }
    private boolean canPlace(int[] s, int k, int d) {
        int cnt = 1, last = s[0];
        for (int i = 1; i < s.length; i++)
            if (s[i] - last >= d) { cnt++; last = s[i]; if (cnt >= k) return true; }
        return false;
    }
}
