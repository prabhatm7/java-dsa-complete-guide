/*
 * Problem: Frog Jump — min energy to reach last stone with jumps of 1 or 2 (cost = abs height diff).
 *
 * Intuition: dp[i] = min(dp[i-1]+|h[i]-h[i-1]|, dp[i-2]+|h[i]-h[i-2]|).
 * Time: O(n)  Space: O(1)
 */
public class FrogJump {
    public int frogJump(int[] h) {
        int prev2 = 0, prev1 = 0;
        for (int i = 1; i < h.length; i++) {
            int one = prev1 + Math.abs(h[i] - h[i-1]);
            int two = i > 1 ? prev2 + Math.abs(h[i] - h[i-2]) : Integer.MAX_VALUE;
            int cur = Math.min(one, two);
            prev2 = prev1; prev1 = cur;
        }
        return prev1;
    }
}
