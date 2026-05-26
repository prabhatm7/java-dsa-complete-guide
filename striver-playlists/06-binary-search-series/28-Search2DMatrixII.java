/*
 * Problem: Search in 2D Matrix II (each row/col sorted).
 *
 * Intuition: Start at top-right; if cur>t move left, if cur<t move down.
 * Time: O(n+m)  Space: O(1)
 */
public class Search2DMatrixII {
    public boolean searchMatrix(int[][] mat, int t) {
        int n = mat.length, m = mat[0].length;
        int r = 0, c = m - 1;
        while (r < n && c >= 0) {
            if (mat[r][c] == t) return true;
            if (mat[r][c] > t) c--; else r++;
        }
        return false;
    }
}
