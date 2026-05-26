/*
 * Problem: Distinct Subsequences — count subsequences of s equal to t.
 *
 * Intuition: dp[i][j] = if match dp[i-1][j-1]+dp[i-1][j] else dp[i-1][j].
 * Time: O(n*m)  Space: O(m)
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = m; j >= 1; j--)
                if (s.charAt(i-1) == t.charAt(j-1)) dp[j] += dp[j-1];
        return dp[m];
    }
}
