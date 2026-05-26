/*
 * Problem: Count Occurrences of a target in sorted array.
 *
 * Intuition: upper - lower.
 * Time: O(log n)  Space: O(1)
 */
public class CountOccurrences {
    public int count(int[] a, int t) {
        int lo = lb(a, t);
        if (lo == a.length || a[lo] != t) return 0;
        return ub(a, t) - lo;
    }
    private int lb(int[] a, int t) { int l = 0, r = a.length; while (l < r) { int m = (l+r) >>> 1; if (a[m] >= t) r = m; else l = m+1; } return l; }
    private int ub(int[] a, int t) { int l = 0, r = a.length; while (l < r) { int m = (l+r) >>> 1; if (a[m] > t) r = m; else l = m+1; } return l; }
}
