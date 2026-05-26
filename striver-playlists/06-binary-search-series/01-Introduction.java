/*
 * Problem: Binary Search on sorted array — find index of target.
 *
 * Intuition: Repeatedly halve search range; compare with middle.
 * Time: O(log n)  Space: O(1)
 */
public class Introduction {
    public int search(int[] a, int t) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int m = (lo + hi) >>> 1;
            if (a[m] == t) return m;
            if (a[m] < t) lo = m + 1; else hi = m - 1;
        }
        return -1;
    }
}
