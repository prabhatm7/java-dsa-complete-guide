/*
 * Problem: Egg Drop — min trials to determine threshold floor with e eggs and f floors.
 *
 * Intuition: dp[e][f] = 1 + min over k of max(dp[e-1][k-1] (break), dp[e][f-k] (survive)).
 * Time: O(e*f^2)  Space: O(e*f)
 */
public class EggDrop {
    public int superEggDrop(int e, int f) {
        int[][] dp = new int[e + 1][f + 1];
        for (int j = 1; j <= f; j++) dp[1][j] = j;
        for (int i = 2; i <= e; i++)
            for (int j = 1; j <= f; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++)
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i-1][k-1], dp[i][j-k]));
            }
        return dp[e][f];
    }
}
