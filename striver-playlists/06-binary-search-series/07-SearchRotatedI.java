/*
 * Problem: Search in Rotated Sorted Array (unique).
 *
 * Intuition: Identify sorted half; check if target lies in it.
 * Time: O(log n)  Space: O(1)
 */
public class SearchRotatedI {
    public int search(int[] a, int t) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int m = (lo + hi) >>> 1;
            if (a[m] == t) return m;
            if (a[lo] <= a[m]) {
                if (t >= a[lo] && t < a[m]) hi = m - 1; else lo = m + 1;
            } else {
                if (t > a[m] && t <= a[hi]) lo = m + 1; else hi = m - 1;
            }
        }
        return -1;
    }
}
