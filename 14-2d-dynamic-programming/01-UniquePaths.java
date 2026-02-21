// LC 62. Unique Paths
// Approach: Top-down memoization. dfs(i, j) = number of paths from (i,j) to (m-1, n-1).
// Can only move right or down. dfs(i,j) = dfs(i+1,j) + dfs(i,j+1).
// Time: O(m*n) | Space: O(m*n)
class UniquePaths {
    private Integer[][] memo;

    public int uniquePaths(int m, int n) {
        memo = new Integer[m][n];
        return dfs(0, 0, m, n);
    }

    private int dfs(int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) return 1;
        if (i >= m || j >= n) return 0;
        if (memo[i][j] != null) return memo[i][j];
        memo[i][j] = dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
        return memo[i][j];
    }
}
