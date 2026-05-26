/*
 * Problem: Matrix Chain Multiplication.
 *
 * Intuition: dp[i][j] = min over k of dp[i][k] + dp[k+1][j] + p[i-1]*p[k]*p[j].
 * Time: O(n^3)  Space: O(n^2)
 */
public class MCM {
    public int mcm(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++)
            for (int i = 1; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++)
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + p[i-1]*p[k]*p[j]);
            }
        return dp[1][n-1];
    }
}
