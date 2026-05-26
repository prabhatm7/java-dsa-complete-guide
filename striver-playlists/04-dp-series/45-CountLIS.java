/*
 * Problem: Number of Longest Increasing Subsequence.
 *
 * Intuition: dp[i] = LIS length ending at i; cnt[i] = number of such LIS; combine on tie or update on longer.
 * Time: O(n^2)  Space: O(n)
 */
public class CountLIS {
    public int findNumberOfLIS(int[] a) {
        int n = a.length;
        int[] dp = new int[n], cnt = new int[n];
        int best = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1; cnt[i] = 1;
            for (int j = 0; j < i; j++)
                if (a[j] < a[i]) {
                    if (dp[j] + 1 > dp[i]) { dp[i] = dp[j] + 1; cnt[i] = cnt[j]; }
                    else if (dp[j] + 1 == dp[i]) cnt[i] += cnt[j];
                }
            best = Math.max(best, dp[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) if (dp[i] == best) ans += cnt[i];
        return ans;
    }
}
