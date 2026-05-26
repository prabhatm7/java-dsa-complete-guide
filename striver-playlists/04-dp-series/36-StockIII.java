/*
 * Problem: Stock III — at most 2 transactions.
 *
 * Intuition: Track buy1/sell1/buy2/sell2 greedily through one pass.
 * Time: O(n)  Space: O(1)
 */
public class StockIII {
    public int maxProfit(int[] p) {
        int b1 = Integer.MIN_VALUE, s1 = 0, b2 = Integer.MIN_VALUE, s2 = 0;
        for (int x : p) {
            b1 = Math.max(b1, -x);
            s1 = Math.max(s1, b1 + x);
            b2 = Math.max(b2, s1 - x);
            s2 = Math.max(s2, b2 + x);
        }
        return s2;
    }
}
