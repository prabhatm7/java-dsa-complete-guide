/*
 * Problem: Burst Balloons — maximize coins.
 *
 * Intuition: Add virtual 1s; dp[i][j] = max over k of dp[i][k] + dp[k][j] + nums[i]*nums[k]*nums[j].
 * Time: O(n^3)  Space: O(n^2)
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] a = new int[n + 2];
        for (int i = 0; i < n; i++) a[i + 1] = nums[i];
        a[0] = a[n + 1] = 1;
        int m = a.length;
        int[][] dp = new int[m][m];
        for (int len = 2; len < m; len++)
            for (int i = 0; i + len < m; i++) {
                int j = i + len;
                for (int k = i + 1; k < j; k++) {
                    int v = dp[i][k] + dp[k][j] + a[i]*a[k]*a[j];
                    if (v > dp[i][j]) dp[i][j] = v;
                }
            }
        return dp[0][m-1];
    }
}
