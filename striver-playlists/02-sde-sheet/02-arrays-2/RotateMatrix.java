/*
 * Problem: Rotate Image (90 deg clockwise)
 * Rotate n x n matrix in-place by 90 degrees clockwise.
 *
 * Intuition: Transpose the matrix, then reverse each row.
 * Time: O(n^2)  Space: O(1)
 */
public class RotateMatrix {
    public void rotate(int[][] m) {
        int n = m.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int t = m[i][j]; m[i][j] = m[j][i]; m[j][i] = t;
            }
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) { int t = m[i][l]; m[i][l++] = m[i][r]; m[i][r--] = t; }
        }
    }
}
