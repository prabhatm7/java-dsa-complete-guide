/*
 * Problem: Longest Palindromic Subsequence.
 *
 * Intuition: LPS(s) = LCS(s, reverse(s)).
 * Time: O(n^2)  Space: O(n^2)
 */
public class LPS {
    public int longestPalindromeSubseq(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = s.charAt(i-1) == r.charAt(j-1) ? 1 + dp[i-1][j-1] : Math.max(dp[i-1][j], dp[i][j-1]);
        return dp[n][n];
    }
}
