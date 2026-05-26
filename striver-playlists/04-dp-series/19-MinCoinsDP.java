/*
 * Problem: Min Coins to Make Amount (unbounded coins).
 *
 * Intuition: dp[x] = min coins; iterate x ascending and dp[x] = min(dp[x], dp[x-c]+1).
 * Time: O(n*amount)  Space: O(amount)
 */
import java.util.*;
public class MinCoinsDP {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int x = 1; x <= amount; x++)
            for (int c : coins) if (c <= x) dp[x] = Math.min(dp[x], dp[x-c] + 1);
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
