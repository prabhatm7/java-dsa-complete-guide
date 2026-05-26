/*
 * Problem: First and Last Occurrence of target.
 *
 * Intuition: lowerBound(t) and upperBound(t)-1.
 * Time: O(log n)  Space: O(1)
 */
public class FirstLastOccurrence {
    public int[] searchRange(int[] a, int t) {
        int lo = lower(a, t);
        if (lo == a.length || a[lo] != t) return new int[]{-1, -1};
        return new int[]{lo, upper(a, t) - 1};
    }
    private int lower(int[] a, int t) {
        int l = 0, r = a.length;
        while (l < r) { int m = (l + r) >>> 1; if (a[m] >= t) r = m; else l = m + 1; }
        return l;
    }
    private int upper(int[] a, int t) {
        int l = 0, r = a.length;
        while (l < r) { int m = (l + r) >>> 1; if (a[m] > t) r = m; else l = m + 1; }
        return l;
    }
}
