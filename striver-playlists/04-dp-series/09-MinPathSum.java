/*
 * Problem: Min Path Sum in grid (right/down).
 *
 * Intuition: dp[i][j] = g[i][j] + min(dp[i-1][j], dp[i][j-1]).
 * Time: O(m*n)  Space: O(n)
 */
public class MinPathSum {
    public int minPathSum(int[][] g) {
        int m = g.length, n = g[0].length;
        int[] dp = new int[n];
        dp[0] = g[0][0];
        for (int j = 1; j < n; j++) dp[j] = dp[j-1] + g[0][j];
        for (int i = 1; i < m; i++) {
            dp[0] += g[i][0];
            for (int j = 1; j < n; j++) dp[j] = g[i][j] + Math.min(dp[j], dp[j-1]);
        }
        return dp[n-1];
    }
}
