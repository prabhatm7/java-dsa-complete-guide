/*
 * Problem: Minimum Path Sum in Grid (right/down only).
 *
 * Intuition: dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1]); 1D rolling possible.
 * Time: O(n*m)  Space: O(m)
 */
public class MinPathSum {
    public int minPathSum(int[][] g) {
        int n = g.length, m = g[0].length;
        int[] dp = new int[m];
        dp[0] = g[0][0];
        for (int j = 1; j < m; j++) dp[j] = dp[j-1] + g[0][j];
        for (int i = 1; i < n; i++) {
            dp[0] += g[i][0];
            for (int j = 1; j < m; j++) dp[j] = g[i][j] + Math.min(dp[j], dp[j-1]);
        }
        return dp[m-1];
    }
}
