/*
 * Problem: Rod Cutting.
 *
 * Intuition: Unbounded knapsack — dp[x] = max(dp[x], price[i] + dp[x-i-1]).
 * Time: O(n^2)  Space: O(n)
 */
public class RodCutting {
    public int cutRod(int[] price, int n) {
        int[] dp = new int[n + 1];
        for (int x = 1; x <= n; x++)
            for (int i = 1; i <= x; i++) dp[x] = Math.max(dp[x], price[i-1] + dp[x - i]);
        return dp[n];
    }
}
