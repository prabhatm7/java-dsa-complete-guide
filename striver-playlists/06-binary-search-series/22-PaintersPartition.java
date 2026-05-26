/*
 * Problem: Painter's Partition — same as allocate pages.
 *
 * Intuition: BS on max workload; check if k painters suffice.
 * Time: O(n log sum)  Space: O(1)
 */
public class PaintersPartition {
    public int painter(int[] boards, int k) {
        int lo = 0, hi = 0;
        for (int x : boards) { lo = Math.max(lo, x); hi += x; }
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (count(boards, mid) <= k) hi = mid - 1; else lo = mid + 1;
        }
        return lo;
    }
    private int count(int[] a, int cap) {
        int p = 1, c = 0;
        for (int x : a) { if (c + x > cap) { p++; c = x; } else c += x; }
        return p;
    }
}
