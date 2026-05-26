/*
 * Problem: Median in a row-wise sorted matrix.
 *
 * Intuition: BS on answer in [min, max]; for each mid, count elements <= mid; if count <= n*m/2, go right.
 * Time: O(32 * n * log m)  Space: O(1)
 */
import java.util.*;
public class MatrixMedian {
    public int findMedian(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int lo = 1, hi = (int)1e9;
        while (lo <= hi) {
            int mid = (lo + hi) / 2, cnt = 0;
            for (int i = 0; i < n; i++) cnt += upperBound(mat[i], mid);
            if (cnt <= (n*m)/2) lo = mid + 1; else hi = mid - 1;
        }
        return lo;
    }
    private int upperBound(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) { int m = (l + r) / 2; if (a[m] <= x) l = m + 1; else r = m; }
        return l;
    }
}
