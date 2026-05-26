/*
 * Problem: Find Peak Element (a[i] > neighbors).
 *
 * Intuition: BS toward greater neighbor; guaranteed peak exists.
 * Time: O(log n)  Space: O(1)
 */
public class PeakElement {
    public int findPeakElement(int[] a) {
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int m = (lo + hi) >>> 1;
            if (a[m] > a[m + 1]) hi = m; else lo = m + 1;
        }
        return lo;
    }
}
