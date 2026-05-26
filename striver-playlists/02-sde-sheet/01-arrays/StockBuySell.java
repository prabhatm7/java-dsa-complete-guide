/*
 * Problem: Best Time to Buy and Sell Stock
 * Single transaction allowed; maximize profit.
 *
 * Intuition: Track minimum price seen so far; profit = price - min; keep best.
 * Time: O(n)  Space: O(1)
 */
public class StockBuySell {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, best = 0;
        for (int p : prices) {
            if (p < min) min = p;
            else if (p - min > best) best = p - min;
        }
        return best;
    }
}
