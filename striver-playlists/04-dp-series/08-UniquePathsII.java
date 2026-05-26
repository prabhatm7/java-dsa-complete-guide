/*
 * Problem: Unique Paths II — with obstacles.
 *
 * Intuition: Same DP; if grid[i][j] == 1, dp[j] = 0.
 * Time: O(m*n)  Space: O(n)
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] g) {
        int m = g.length, n = g[0].length;
        int[] dp = new int[n];
        dp[0] = g[0][0] == 0 ? 1 : 0;
        for (int j = 1; j < n; j++) dp[j] = g[0][j] == 1 ? 0 : dp[j-1];
        for (int i = 1; i < m; i++) {
            dp[0] = g[i][0] == 1 ? 0 : dp[0];
            for (int j = 1; j < n; j++) dp[j] = g[i][j] == 1 ? 0 : dp[j] + dp[j-1];
        }
        return dp[n-1];
    }
}
