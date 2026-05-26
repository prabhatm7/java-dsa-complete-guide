/*
 * Problem: Partition Array for Maximum Sum (k-length max partitions, replace with max).
 *
 * Intuition: dp[i] = max over last partition size 1..k of dp[i-size] + size*maxInThatRange.
 * Time: O(n*k)  Space: O(n)
 */
public class PartitionForMaxSum {
    public int maxSumAfterPartitioning(int[] a, int k) {
        int n = a.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int mx = 0;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                mx = Math.max(mx, a[i - j]);
                dp[i] = Math.max(dp[i], dp[i - j] + mx * j);
            }
        }
        return dp[n];
    }
}
