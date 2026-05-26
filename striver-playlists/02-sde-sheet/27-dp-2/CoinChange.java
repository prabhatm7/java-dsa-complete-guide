/*
 * Problem: Coin Change — minimum coins to make amount.
 *
 * Intuition: dp[x] = 1 + min(dp[x - coin]) over coins; init INF, dp[0]=0.
 * Time: O(amount*n)  Space: O(amount)
 */
import java.util.*;
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int x = 1; x <= amount; x++)
            for (int c : coins) if (c <= x) dp[x] = Math.min(dp[x], 1 + dp[x - c]);
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
