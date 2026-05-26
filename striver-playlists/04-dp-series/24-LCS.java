/*
 * Problem: Longest Common Subsequence.
 *
 * Intuition: dp[i][j] = match ? 1+dp[i-1][j-1] : max(dp[i-1][j], dp[i][j-1]).
 * Time: O(n*m)  Space: O(n*m)
 */
public class LCS {
    public int lcs(String a, String b) {
        int n = a.length(), m = b.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                dp[i][j] = a.charAt(i-1) == b.charAt(j-1) ? 1 + dp[i-1][j-1] : Math.max(dp[i-1][j], dp[i][j-1]);
        return dp[n][m];
    }
}
