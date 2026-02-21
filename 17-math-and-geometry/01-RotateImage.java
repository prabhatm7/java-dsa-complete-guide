// LC 48. Rotate Image (90 degrees clockwise)
// Approach: Transpose matrix (swap [i][j] with [j][i]), then reverse each row.
// Time: O(n^2) | Space: O(1)
class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        for (int[] row : matrix) {
            int l = 0, r = n - 1;
            while (l < r) { int temp = row[l]; row[l++] = row[r]; row[r--] = temp; }
        }
    }
}
