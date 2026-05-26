/*
 * Problem: Stock with Cooldown.
 *
 * Intuition: Three states (hold, sold, rest); transitions enforce cooldown after sell.
 * Time: O(n)  Space: O(1)
 */
public class StockWithCooldown {
    public int maxProfit(int[] p) {
        int hold = Integer.MIN_VALUE, sold = 0, rest = 0;
        for (int x : p) {
            int newHold = Math.max(hold, rest - x);
            int newSold = hold + x;
            int newRest = Math.max(rest, sold);
            hold = newHold; sold = newSold; rest = newRest;
        }
        return Math.max(sold, rest);
    }
}
