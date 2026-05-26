/*
 * Problem: Partition Equal Subset Sum.
 *
 * Intuition: If total odd return false; else subset sum target = total / 2.
 * Time: O(n*sum)  Space: O(sum)
 */
public class PartitionEqualSubset {
    public boolean canPartition(int[] a) {
        int s = 0;
        for (int x : a) s += x;
        if ((s & 1) == 1) return false;
        int t = s / 2;
        boolean[] dp = new boolean[t + 1];
        dp[0] = true;
        for (int x : a) for (int k = t; k >= x; k--) dp[k] = dp[k] || dp[k - x];
        return dp[t];
    }
}
