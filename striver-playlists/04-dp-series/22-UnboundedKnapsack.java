/*
 * Problem: Unbounded Knapsack.
 *
 * Intuition: Like 0/1 but iterate w ascending so items can be reused.
 * Time: O(n*W)  Space: O(W)
 */
public class UnboundedKnapsack {
    public int unboundedKnapsack(int W, int[] wt, int[] val) {
        int[] dp = new int[W + 1];
        for (int i = 0; i < wt.length; i++)
            for (int w = wt[i]; w <= W; w++)
                dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
        return dp[W];
    }
}
