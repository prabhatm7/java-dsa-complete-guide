/*
 * Problem: Set Matrix Zeroes
 * Given an m x n matrix, if a cell is 0, set its entire row and column to 0. Do it in-place.
 *
 * Intuition: Use first row & first column as markers; handle col0 with a separate flag to avoid overlap with [0][0].
 * Time: O(n*m)  Space: O(1)
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int col0 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    if (j != 0) mat[0][j] = 0;
                    else col0 = 0;
                }
            }
        }
        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                if (mat[i][j] != 0 && (mat[i][0] == 0 || mat[0][j] == 0))
                    mat[i][j] = 0;
        if (mat[0][0] == 0) for (int j = 0; j < m; j++) mat[0][j] = 0;
        if (col0 == 0) for (int i = 0; i < n; i++) mat[i][0] = 0;
    }
}
