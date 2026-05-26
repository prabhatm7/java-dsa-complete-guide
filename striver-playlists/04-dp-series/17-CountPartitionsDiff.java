/*
 * Problem: Count Partitions with Given Difference D.
 *
 * Intuition: s1 + s2 = total, s1 - s2 = d => s1 = (total+d)/2; count subsets summing to s1.
 * Time: O(n*sum)  Space: O(sum)
 */
public class CountPartitionsDiff {
    public int countPartitions(int[] a, int d) {
        int total = 0; for (int x : a) total += x;
        if ((total + d) % 2 != 0 || total < d) return 0;
        int t = (total + d) / 2;
        int[] dp = new int[t + 1];
        dp[0] = 1;
        for (int x : a) for (int s = t; s >= x; s--) dp[s] += dp[s - x];
        return dp[t];
    }
}
