/*
 * Problem: Unique Paths in m x n grid.
 *
 * Intuition: dp[i][j] = dp[i-1][j] + dp[i][j-1]; 1D rolling.
 * Time: O(m*n)  Space: O(n)
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) for (int j = 1; j < n; j++) dp[j] += dp[j-1];
        return dp[n-1];
    }
}
