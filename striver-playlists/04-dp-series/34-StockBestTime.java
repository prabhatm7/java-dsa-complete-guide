/*
 * Problem: Stock I — at most one transaction.
 *
 * Intuition: Track min price; profit = price - min; keep max.
 * Time: O(n)  Space: O(1)
 */
public class StockBestTime {
    public int maxProfit(int[] p) {
        int min = Integer.MAX_VALUE, best = 0;
        for (int x : p) { if (x < min) min = x; else best = Math.max(best, x - min); }
        return best;
    }
}
