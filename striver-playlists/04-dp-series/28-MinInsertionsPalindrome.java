/*
 * Problem: Min Insertions to make string palindrome.
 *
 * Intuition: Answer = length - LPS.
 * Time: O(n^2)  Space: O(n^2)
 */
public class MinInsertionsPalindrome {
    public int minInsertions(String s) {
        int n = s.length();
        String r = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = s.charAt(i-1) == r.charAt(j-1) ? 1 + dp[i-1][j-1] : Math.max(dp[i-1][j], dp[i][j-1]);
        return n - dp[n][n];
    }
}
