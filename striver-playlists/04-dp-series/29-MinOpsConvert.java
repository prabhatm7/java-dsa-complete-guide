/*
 * Problem: Min Operations to convert string A to B (only insert/delete).
 *
 * Intuition: Delete (n - LCS) and insert (m - LCS); total = n + m - 2*LCS.
 * Time: O(n*m)  Space: O(n*m)
 */
public class MinOpsConvert {
    public int minOps(String a, String b) {
        int n = a.length(), m = b.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                dp[i][j] = a.charAt(i-1) == b.charAt(j-1) ? 1 + dp[i-1][j-1] : Math.max(dp[i-1][j], dp[i][j-1]);
        return n + m - 2 * dp[n][m];
    }
}
