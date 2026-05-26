/*
 * Problem: Search in Rotated Sorted Array (with duplicates).
 *
 * Intuition: When a[lo]==a[mid]==a[hi], shrink both ends; else apply rotated BS.
 * Time: O(log n) avg, O(n) worst  Space: O(1)
 */
public class SearchRotatedII {
    public boolean search(int[] a, int t) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int m = (lo + hi) >>> 1;
            if (a[m] == t) return true;
            if (a[lo] == a[m] && a[m] == a[hi]) { lo++; hi--; continue; }
            if (a[lo] <= a[m]) {
                if (t >= a[lo] && t < a[m]) hi = m - 1; else lo = m + 1;
            } else {
                if (t > a[m] && t <= a[hi]) lo = m + 1; else hi = m - 1;
            }
        }
        return false;
    }
}
