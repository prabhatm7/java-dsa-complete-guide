/*
 * Problem: Capacity to Ship Packages within D days.
 *
 * Intuition: BS on capacity in [max(weights), sum(weights)]; greedily simulate days.
 * Time: O(n log sum)  Space: O(1)
 */
public class ShipDDays {
    public int shipWithinDays(int[] w, int d) {
        int lo = 0, hi = 0;
        for (int x : w) { lo = Math.max(lo, x); hi += x; }
        while (lo < hi) {
            int m = (lo + hi) >>> 1;
            int days = 1, cur = 0;
            for (int x : w) { if (cur + x > m) { days++; cur = x; } else cur += x; }
            if (days <= d) hi = m; else lo = m + 1;
        }
        return lo;
    }
}
