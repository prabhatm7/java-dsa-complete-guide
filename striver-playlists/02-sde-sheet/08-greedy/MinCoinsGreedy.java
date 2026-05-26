/*
 * Problem: Minimum Coins for Indian denominations [1,2,5,10,20,50,100,200,500,2000].
 *
 * Intuition: Greedy works because denominations are canonical; pick largest <= remaining.
 * Time: O(n)  Space: O(1)
 */
import java.util.*;
public class MinCoinsGreedy {
    public List<Integer> minCoins(int amount) {
        int[] d = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        List<Integer> res = new ArrayList<>();
        for (int x : d) {
            while (amount >= x) { res.add(x); amount -= x; }
        }
        return res;
    }
}
