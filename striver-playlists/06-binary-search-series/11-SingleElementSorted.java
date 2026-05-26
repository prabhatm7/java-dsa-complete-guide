/*
 * Problem: Single Element in a sorted array where every other element appears twice.
 *
 * Intuition: Pair index parity check with mid XOR 1.
 * Time: O(log n)  Space: O(1)
 */
public class SingleElementSorted {
    public int singleNonDuplicate(int[] a) {
        int lo = 0, hi = a.length - 2;
        while (lo <= hi) {
            int m = (lo + hi) >>> 1;
            if (a[m] == a[m ^ 1]) lo = m + 1; else hi = m - 1;
        }
        return a[lo];
    }
}
