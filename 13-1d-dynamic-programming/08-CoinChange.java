// LC 322. Coin Change
// Approach: Top-down memoization. dfs(amount) = min coins to make that amount.
// Try each coin: 1 + dfs(amount - coin). Return min across all coins.
// Time: O(amount * n) | Space: O(amount)
import java.util.*;

class CoinChange {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int res = dfs(coins, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (memo.containsKey(amount)) return memo.get(amount);
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dfs(coins, amount - coin);
            if (sub != Integer.MAX_VALUE) min = Math.min(min, 1 + sub);
        }
        memo.put(amount, min);
        return min;
    }
}
