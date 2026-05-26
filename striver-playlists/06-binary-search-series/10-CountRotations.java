/*
 * Problem: Number of times sorted array is rotated (index of min).
 *
 * Intuition: Index of minimum element via BS.
 * Time: O(log n)  Space: O(1)
 */
public class CountRotations {
    public int rotations(int[] a) {
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int m = (lo + hi) >>> 1;
            if (a[m] > a[hi]) lo = m + 1; else hi = m;
        }
        return lo;
    }
}
