// LC 518. Coin Change II (number of combinations)
// Approach: Top-down memoization. dfs(i, amount) = number of ways using coins[i..] to make amount.
// Use coin[i] again: dfs(i, amount - coins[i]). Skip coin[i]: dfs(i+1, amount).
// Time: O(n * amount) | Space: O(n * amount)
class CoinChangeII {
    private Integer[][] memo;

    public int change(int amount, int[] coins) {
        memo = new Integer[coins.length][amount + 1];
        return dfs(coins, 0, amount);
    }

    private int dfs(int[] coins, int i, int amount) {
        if (amount == 0) return 1;
        if (i >= coins.length || amount < 0) return 0;
        if (memo[i][amount] != null) return memo[i][amount];
        memo[i][amount] = dfs(coins, i, amount - coins[i]) + dfs(coins, i + 1, amount);
        return memo[i][amount];
    }
}
