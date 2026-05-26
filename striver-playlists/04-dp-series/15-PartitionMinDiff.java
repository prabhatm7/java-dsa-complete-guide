/*
 * Problem: Partition into two subsets with minimum absolute sum difference.
 *
 * Intuition: Subset sum DP; find largest s1 ≤ total/2 achievable; answer = total - 2*s1.
 * Time: O(n*sum)  Space: O(sum)
 */
public class PartitionMinDiff {
    public int minSubsetSumDifference(int[] a) {
        int total = 0;
        for (int x : a) total += x;
        boolean[] dp = new boolean[total + 1];
        dp[0] = true;
        for (int x : a) for (int s = total; s >= x; s--) dp[s] = dp[s] || dp[s - x];
        int best = Integer.MAX_VALUE;
        for (int s = 0; s <= total / 2; s++) if (dp[s]) best = Math.min(best, total - 2 * s);
        return best;
    }
}
