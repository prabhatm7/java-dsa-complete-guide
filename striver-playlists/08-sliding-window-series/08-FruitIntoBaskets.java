/*
 * Problem: Fruit into Baskets — longest with at most 2 distinct.
 *
 * Intuition: Sliding window with at most 2 distinct values.
 * Time: O(n)  Space: O(1)
 */
import java.util.*;
public class FruitIntoBaskets {
    public int totalFruit(int[] f) {
        Map<Integer, Integer> m = new HashMap<>();
        int l = 0, best = 0;
        for (int r = 0; r < f.length; r++) {
            m.merge(f[r], 1, Integer::sum);
            while (m.size() > 2) { if (m.merge(f[l], -1, Integer::sum) == 0) m.remove(f[l]); l++; }
            best = Math.max(best, r - l + 1);
        }
        return best;
    }
}
