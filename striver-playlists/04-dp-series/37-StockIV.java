/*
 * Problem: Stock IV — at most k transactions.
 *
 * Intuition: For each transaction t, track buy[t] and sell[t]; iterate all prices, update.
 * Time: O(n*k)  Space: O(k)
 */
public class StockIV {
    public int maxProfit(int k, int[] p) {
        if (k == 0 || p.length == 0) return 0;
        int[] buy = new int[k + 1], sell = new int[k + 1];
        for (int i = 0; i <= k; i++) buy[i] = Integer.MIN_VALUE;
        for (int x : p)
            for (int t = 1; t <= k; t++) {
                buy[t] = Math.max(buy[t], sell[t-1] - x);
                sell[t] = Math.max(sell[t], buy[t] + x);
            }
        return sell[k];
    }
}
