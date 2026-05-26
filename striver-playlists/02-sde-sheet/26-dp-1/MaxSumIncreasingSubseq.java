/*
 * Problem: Maximum Sum Increasing Subsequence.
 *
 * Intuition: dp[i] = a[i] + max(dp[j]) over j<i with a[j]<a[i]; answer = max(dp).
 * Time: O(n^2)  Space: O(n)
 */
public class MaxSumIncreasingSubseq {
    public int maxSumIS(int[] a) {
        int n = a.length, best = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = a[i];
            for (int j = 0; j < i; j++) if (a[j] < a[i]) dp[i] = Math.max(dp[i], dp[j] + a[i]);
            best = Math.max(best, dp[i]);
        }
        return best;
    }
}
