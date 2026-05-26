/*
 * Problem: Longest Increasing Subsequence (O(n^2) DP).
 *
 * Intuition: dp[i] = 1 + max(dp[j]) over j<i with a[j]<a[i]; answer = max(dp).
 * Time: O(n^2)  Space: O(n)
 */
public class LIS_DP_N2 {
    public int lengthOfLIS(int[] a) {
        int n = a.length, best = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) if (a[j] < a[i] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
            best = Math.max(best, dp[i]);
        }
        return best;
    }
}
