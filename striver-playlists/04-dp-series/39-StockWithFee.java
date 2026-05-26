/*
 * Problem: Stock with Transaction Fee.
 *
 * Intuition: hold = max(hold, cash - price); cash = max(cash, hold + price - fee).
 * Time: O(n)  Space: O(1)
 */
public class StockWithFee {
    public int maxProfit(int[] p, int fee) {
        int hold = -p[0], cash = 0;
        for (int i = 1; i < p.length; i++) {
            int newHold = Math.max(hold, cash - p[i]);
            cash = Math.max(cash, hold + p[i] - fee);
            hold = newHold;
        }
        return cash;
    }
}
