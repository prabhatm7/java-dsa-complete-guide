/*
 * Problem: Smallest divisor such that sum of ceilings <= threshold.
 *
 * Intuition: BS on divisor in [1, max(nums)].
 * Time: O(n log max)  Space: O(1)
 */
public class SmallestDivisor {
    public int smallestDivisor(int[] a, int t) {
        int lo = 1, hi = 0;
        for (int x : a) hi = Math.max(hi, x);
        while (lo < hi) {
            int m = (lo + hi) >>> 1;
            long s = 0;
            for (int x : a) s += (x + m - 1) / m;
            if (s <= t) hi = m; else lo = m + 1;
        }
        return lo;
    }
}
