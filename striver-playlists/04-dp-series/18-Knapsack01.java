/*
 * Problem: 0/1 Knapsack.
 *
 * Intuition: dp[w] = max value with capacity w; iterate w desc to avoid reuse.
 * Time: O(n*W)  Space: O(W)
 */
public class Knapsack01 {
    public int knapsack(int W, int[] wt, int[] val) {
        int[] dp = new int[W + 1];
        for (int i = 0; i < wt.length; i++)
            for (int w = W; w >= wt[i]; w--)
                dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
        return dp[W];
    }
}
