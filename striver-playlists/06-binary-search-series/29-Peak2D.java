/*
 * Problem: Find Peak Element in 2D matrix.
 *
 * Intuition: BS on columns; in each col find row of max; compare with horizontal neighbors.
 * Time: O(n log m)  Space: O(1)
 */
public class Peak2D {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int lo = 0, hi = m - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int maxRow = 0;
            for (int i = 0; i < n; i++) if (mat[i][mid] > mat[maxRow][mid]) maxRow = i;
            int left = mid > 0 ? mat[maxRow][mid - 1] : -1;
            int right = mid < m - 1 ? mat[maxRow][mid + 1] : -1;
            if (mat[maxRow][mid] > left && mat[maxRow][mid] > right) return new int[]{maxRow, mid};
            if (left > mat[maxRow][mid]) hi = mid - 1; else lo = mid + 1;
        }
        return new int[]{-1, -1};
    }
}
