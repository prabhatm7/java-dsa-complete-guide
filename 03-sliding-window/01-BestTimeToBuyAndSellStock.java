// LC 121. Best Time to Buy and Sell Stock
// Approach: Track minimum price so far, update max profit at each step
// Time: O(n) | Space: O(1)
class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int p : prices) {
            minPrice = Math.min(minPrice, p);
            maxProfit = Math.max(maxProfit, p - minPrice);
        }
        return maxProfit;
    }
}
