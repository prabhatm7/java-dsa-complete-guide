/*
 * Problem: 0/1 Knapsack.
 *
 * Intuition: For each item: take (val + dp[w - wt]) or skip; iterate w descending for 1D rolling.
 * Time: O(n*W)  Space: O(W)
 */
public class Knapsack01 {
    public int knapSack(int W, int[] wt, int[] val) {
        int n = wt.length;
        int[] dp = new int[W + 1];
        for (int i = 0; i < n; i++)
            for (int w = W; w >= wt[i]; w--)
                dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
        return dp[W];
    }
}
