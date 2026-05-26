/*
 * Problem: Kth Missing Positive Number in sorted array.
 *
 * Intuition: missing(i) = a[i] - (i+1); BS first index where missing >= k; answer = k + lo.
 * Time: O(log n)  Space: O(1)
 */
public class KthMissing {
    public int findKthPositive(int[] a, int k) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int m = (lo + hi) >>> 1;
            int missing = a[m] - (m + 1);
            if (missing >= k) hi = m; else lo = m + 1;
        }
        return lo + k;
    }
}
