/*
 * Problem: Split Array Largest Sum (minimize the largest sum among m subarrays).
 *
 * Intuition: BS on answer; greedy partitioning.
 * Time: O(n log sum)  Space: O(1)
 */
public class MinMaxSplit {
    public int splitArray(int[] a, int m) {
        int lo = 0, hi = 0;
        for (int x : a) { lo = Math.max(lo, x); hi += x; }
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (split(a, mid) <= m) hi = mid - 1; else lo = mid + 1;
        }
        return lo;
    }
    private int split(int[] a, int cap) {
        int p = 1, c = 0;
        for (int x : a) { if (c + x > cap) { p++; c = x; } else c += x; }
        return p;
    }
}
