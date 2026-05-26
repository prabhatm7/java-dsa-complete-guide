/*
 * Problem: Subset Sum — does a subset summing to target exist?
 *
 * Intuition: dp[x] true if achievable; for each num, traverse x desc and OR with dp[x-num].
 * Time: O(n*target)  Space: O(target)
 */
public class SubsetSum {
    public boolean isSubsetSum(int[] a, int t) {
        boolean[] dp = new boolean[t + 1];
        dp[0] = true;
        for (int x : a) for (int s = t; s >= x; s--) dp[s] = dp[s] || dp[s - x];
        return dp[t];
    }
}
