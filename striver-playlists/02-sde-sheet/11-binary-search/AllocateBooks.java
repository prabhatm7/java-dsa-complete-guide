/*
 * Problem: Allocate Minimum Number of Pages (books to m students, contiguous).
 *
 * Intuition: BS on answer in [max(pages), sum(pages)]; check if allocation possible with ≤ m students.
 * Time: O(n log sum)  Space: O(1)
 */
public class AllocateBooks {
    public int allocate(int[] a, int m) {
        if (m > a.length) return -1;
        int lo = 0, hi = 0;
        for (int x : a) { lo = Math.max(lo, x); hi += x; }
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (students(a, mid) <= m) hi = mid - 1; else lo = mid + 1;
        }
        return lo;
    }
    private int students(int[] a, int cap) {
        int cnt = 1, cur = 0;
        for (int x : a) { if (cur + x > cap) { cnt++; cur = x; } else cur += x; }
        return cnt;
    }
}
