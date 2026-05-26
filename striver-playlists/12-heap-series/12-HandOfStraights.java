/*
 * Problem: Hand of Straights — partition into groups of k consecutive cards.
 *
 * Intuition: TreeMap counts; repeatedly start from smallest and consume k consecutive.
 * Time: O(n log n)  Space: O(n)
 */
import java.util.*;
public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int k) {
        if (hand.length % k != 0) return false;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int x : hand) m.merge(x, 1, Integer::sum);
        while (!m.isEmpty()) {
            int start = m.firstKey();
            for (int i = 0; i < k; i++) {
                int key = start + i;
                if (!m.containsKey(key)) return false;
                if (m.get(key) == 1) m.remove(key);
                else m.merge(key, -1, Integer::sum);
            }
        }
        return true;
    }
}
