/*
 * Problem: Target Sum — assign +/- to each num so sum equals target.
 *
 * Intuition: Equivalent to count subsets with sum (total + target) / 2.
 * Time: O(n*sum)  Space: O(sum)
 */
public class TargetSum {
    public int findTargetSumWays(int[] a, int t) {
        int total = 0; for (int x : a) total += x;
        if ((total + t) % 2 != 0 || Math.abs(t) > total) return 0;
        int s = (total + t) / 2;
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int x : a) for (int k = s; k >= x; k--) dp[k] += dp[k - x];
        return dp[s];
    }
}
