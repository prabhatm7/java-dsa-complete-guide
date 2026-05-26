/*
 * Problem: Palindrome Partitioning II — min cuts.
 *
 * Intuition: For each end i find best j with s[j..i] palindrome; dp[i] = dp[j-1] + 1 (0 if j=0).
 * Time: O(n^2)  Space: O(n^2)
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] p = new boolean[n][n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j < 2 || p[j+1][i-1])) {
                    p[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, dp[j-1] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[n-1];
    }
}
