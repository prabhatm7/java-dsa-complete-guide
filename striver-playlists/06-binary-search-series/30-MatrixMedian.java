/*
 * Problem: Median of row-sorted matrix.
 *
 * Intuition: BS on value in [1, max]; count cells <= mid; if <= n*m/2 go right.
 * Time: O(32 * n log m)  Space: O(1)
 */
public class MatrixMedian {
    public int findMedian(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int lo = 1, hi = (int) 1e9;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1, cnt = 0;
            for (int i = 0; i < n; i++) cnt += upper(mat[i], mid);
            if (cnt <= (n*m)/2) lo = mid + 1; else hi = mid - 1;
        }
        return lo;
    }
    private int upper(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) { int mm = (l+r) >>> 1; if (a[mm] <= x) l = mm + 1; else r = mm; }
        return l;
    }
}
