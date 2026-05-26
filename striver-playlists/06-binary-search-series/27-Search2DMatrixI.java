/*
 * Problem: Search in 2D Matrix (rows sorted, first of each > last of previous).
 *
 * Intuition: Treat as 1D; BS on n*m elements.
 * Time: O(log(n*m))  Space: O(1)
 */
public class Search2DMatrixI {
    public boolean searchMatrix(int[][] mat, int t) {
        int n = mat.length, m = mat[0].length;
        int lo = 0, hi = n * m - 1;
        while (lo <= hi) {
            int x = (lo + hi) >>> 1;
            int v = mat[x / m][x % m];
            if (v == t) return true;
            if (v < t) lo = x + 1; else hi = x - 1;
        }
        return false;
    }
}
