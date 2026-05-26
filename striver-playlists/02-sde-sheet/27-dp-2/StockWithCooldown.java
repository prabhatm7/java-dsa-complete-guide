/*
 * Problem: Best Time to Buy/Sell Stock with Cooldown.
 *
 * Intuition: States hold/cash; cash after sell must wait 1 day; track yesterday's cash.
 * Time: O(n)  Space: O(1)
 */
public class StockWithCooldown {
    public int maxProfit(int[] p) {
        int hold = Integer.MIN_VALUE, cash = 0, prevCash = 0;
        for (int x : p) {
            int newHold = Math.max(hold, prevCash - x);
            prevCash = cash;
            cash = Math.max(cash, hold + x);
            hold = newHold;
        }
        return cash;
    }
}
