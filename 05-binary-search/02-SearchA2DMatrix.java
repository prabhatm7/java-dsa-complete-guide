// LC 74. Search a 2D Matrix
// Approach: Treat 2D matrix as 1D sorted array. idx -> matrix[idx/cols][idx%cols]
// Time: O(log(m*n)) | Space: O(1)
class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int val = matrix[mid / n][mid % n];
            if (val == target) return true;
            else if (val < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
}
