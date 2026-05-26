/*
 * Problem: Frog Jump with K steps allowed.
 *
 * Intuition: dp[i] = min over j in [1..k] of dp[i-j] + |h[i] - h[i-j]|.
 * Time: O(n*k)  Space: O(n)
 */
public class FrogJumpK {
    public int frogJumpK(int[] h, int k) {
        int n = h.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            int best = Integer.MAX_VALUE;
            for (int j = 1; j <= k && i - j >= 0; j++)
                best = Math.min(best, dp[i-j] + Math.abs(h[i] - h[i-j]));
            dp[i] = best;
        }
        return dp[n-1];
    }
}
