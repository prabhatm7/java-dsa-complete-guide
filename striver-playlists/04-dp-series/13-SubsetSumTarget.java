/*
 * Problem: Subset Sum Target — exists a subset summing to t?
 *
 * Intuition: dp[s] true if achievable; for each num, iterate s desc.
 * Time: O(n*t)  Space: O(t)
 */
public class SubsetSumTarget {
    public boolean subsetSum(int[] a, int t) {
        boolean[] dp = new boolean[t + 1];
        dp[0] = true;
        for (int x : a) for (int s = t; s >= x; s--) dp[s] = dp[s] || dp[s - x];
        return dp[t];
    }
}
