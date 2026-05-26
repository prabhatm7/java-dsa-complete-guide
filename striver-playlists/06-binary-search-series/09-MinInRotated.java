/*
 * Problem: Minimum in Rotated Sorted Array.
 *
 * Intuition: If a[mid] > a[hi], min is right of mid; else min is at mid or left.
 * Time: O(log n)  Space: O(1)
 */
public class MinInRotated {
    public int findMin(int[] a) {
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int m = (lo + hi) >>> 1;
            if (a[m] > a[hi]) lo = m + 1; else hi = m;
        }
        return a[lo];
    }
}
