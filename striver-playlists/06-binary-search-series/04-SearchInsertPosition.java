/*
 * Problem: Search Insert Position — index where t would be inserted.
 *
 * Intuition: Same as lower_bound.
 * Time: O(log n)  Space: O(1)
 */
public class SearchInsertPosition {
    public int searchInsert(int[] a, int t) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int m = (lo + hi) >>> 1;
            if (a[m] >= t) hi = m; else lo = m + 1;
        }
        return lo;
    }
}
