/*
 * Problem: Upper Bound — first index with a[i] > target.
 *
 * Intuition: BS narrowing right while a[mid] > target.
 * Time: O(log n)  Space: O(1)
 */
public class UpperBound {
    public int upperBound(int[] a, int t) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int m = (lo + hi) >>> 1;
            if (a[m] > t) hi = m; else lo = m + 1;
        }
        return lo;
    }
}
