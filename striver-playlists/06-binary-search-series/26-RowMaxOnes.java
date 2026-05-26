/*
 * Problem: Row with Maximum 1s in sorted (per row) binary matrix.
 *
 * Intuition: For each row, lowerBound(1) gives count = m - lb; track row with max.
 * Time: O(n log m)  Space: O(1)
 */
public class RowMaxOnes {
    public int rowMaxOnes(int[][] mat) {
        int n = mat.length, m = mat[0].length, best = 0, idx = -1;
        for (int i = 0; i < n; i++) {
            int lo = 0, hi = m;
            while (lo < hi) { int x = (lo + hi) / 2; if (mat[i][x] >= 1) hi = x; else lo = x + 1; }
            int cnt = m - lo;
            if (cnt > best) { best = cnt; idx = i; }
        }
        return idx;
    }
}
