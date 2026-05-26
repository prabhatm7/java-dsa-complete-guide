/*
 * Problem: Koko Eating Bananas — minimum eating speed to finish piles in h hours.
 *
 * Intuition: BS on speed in [1, max(piles)]; check sum(ceil(p/k)) <= h.
 * Time: O(n log max)  Space: O(1)
 */
public class KokoBananas {
    public int minEatingSpeed(int[] p, int h) {
        int lo = 1, hi = 0;
        for (int x : p) hi = Math.max(hi, x);
        while (lo < hi) {
            int m = (lo + hi) >>> 1;
            long hours = 0;
            for (int x : p) hours += (x + m - 1) / m;
            if (hours <= h) hi = m; else lo = m + 1;
        }
        return lo;
    }
}
