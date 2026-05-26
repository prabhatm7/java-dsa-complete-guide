/*
 * Problem: Stock II — unlimited transactions.
 *
 * Intuition: Sum every positive consecutive diff.
 * Time: O(n)  Space: O(1)
 */
public class StockII {
    public int maxProfit(int[] p) {
        int ans = 0;
        for (int i = 1; i < p.length; i++) if (p[i] > p[i-1]) ans += p[i] - p[i-1];
        return ans;
    }
}
