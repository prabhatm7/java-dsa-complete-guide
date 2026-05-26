/*
 * Problem: Min Days to make M bouquets of K adjacent flowers.
 *
 * Intuition: BS on day in [min(bloom), max(bloom)]; greedily count bouquets possible by day.
 * Time: O(n log range)  Space: O(1)
 */
public class MBouquets {
    public int minDays(int[] b, int m, int k) {
        long need = (long) m * k;
        if (need > b.length) return -1;
        int lo = Integer.MAX_VALUE, hi = 0;
        for (int x : b) { lo = Math.min(lo, x); hi = Math.max(hi, x); }
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (can(b, mid, m, k)) hi = mid; else lo = mid + 1;
        }
        return lo;
    }
    private boolean can(int[] b, int day, int m, int k) {
        int bouquets = 0, cons = 0;
        for (int x : b) {
            if (x <= day) { cons++; if (cons == k) { bouquets++; cons = 0; } }
            else cons = 0;
        }
        return bouquets >= m;
    }
}
