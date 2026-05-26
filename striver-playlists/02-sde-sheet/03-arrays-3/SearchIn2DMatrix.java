/*
 * Problem: Search a 2D Matrix
 * Rows sorted; first element of each row > last of previous. Search for target.
 *
 * Intuition: Treat as 1D sorted array of size n*m; binary search on index, map to (i,j).
 * Time: O(log(n*m))  Space: O(1)
 */
public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length, m = mat[0].length;
        int lo = 0, hi = n * m - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int v = mat[mid / m][mid % m];
            if (v == target) return true;
            if (v < target) lo = mid + 1; else hi = mid - 1;
        }
        return false;
    }
}
