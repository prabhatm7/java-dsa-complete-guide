// LC 329. Longest Increasing Path in a Matrix
// Approach: Top-down memoization (DFS + memo). dfs(i,j) = longest path starting from (i,j).
// Try 4 directions, only move to strictly greater cells.
// Time: O(m*n) | Space: O(m*n)
class LongestIncreasingPathInAMatrix {
    private int[][] memo;
    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        memo = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                max = Math.max(max, dfs(matrix, i, j));
        return max;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (memo[i][j] != 0) return memo[i][j];
        int max = 1;
        for (int[] d : dirs) {
            int ni = i + d[0], nj = j + d[1];
            if (ni >= 0 && ni < matrix.length && nj >= 0 && nj < matrix[0].length &&
                matrix[ni][nj] > matrix[i][j])
                max = Math.max(max, 1 + dfs(matrix, ni, nj));
        }
        return memo[i][j] = max;
    }
}
