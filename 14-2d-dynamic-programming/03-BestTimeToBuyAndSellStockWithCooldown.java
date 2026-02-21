// LC 309. Best Time to Buy and Sell Stock with Cooldown
// Approach: Top-down memoization with state. dfs(i, holding).
// holding=true: can sell or hold. holding=false: can buy or skip.
// After selling, skip next day (cooldown).
// Time: O(n) | Space: O(n)
class BestTimeToBuyAndSellStockWithCooldown {
    private Integer[][] memo;

    public int maxProfit(int[] prices) {
        memo = new Integer[prices.length][2];
        return dfs(prices, 0, 0);
    }

    // holding: 0 = not holding, 1 = holding
    private int dfs(int[] prices, int i, int holding) {
        if (i >= prices.length) return 0;
        if (memo[i][holding] != null) return memo[i][holding];
        int skip = dfs(prices, i + 1, holding);
        int action;
        if (holding == 1)
            action = prices[i] + dfs(prices, i + 2, 0); // sell + cooldown
        else
            action = -prices[i] + dfs(prices, i + 1, 1); // buy
        memo[i][holding] = Math.max(skip, action);
        return memo[i][holding];
    }
}
