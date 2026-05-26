/*
 * Problem: Allocate Pages — contiguous to m students; minimize max load.
 *
 * Intuition: BS on answer in [max(a), sum(a)]; count students needed for given max load.
 * Time: O(n log sum)  Space: O(1)
 */
public class AllocatePages {
    public int findPages(int[] a, int m) {
        if (m > a.length) return -1;
        int lo = 0, hi = 0;
        for (int x : a) { lo = Math.max(lo, x); hi += x; }
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (students(a, mid) <= m) hi = mid - 1; else lo = mid + 1;
        }
        return lo;
    }
    private int students(int[] a, int cap) {
        int s = 1, cur = 0;
        for (int x : a) { if (cur + x > cap) { s++; cur = x; } else cur += x; }
        return s;
    }
}
