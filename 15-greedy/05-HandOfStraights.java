// LC 846. Hand of Straights
// Approach: TreeMap for sorted counts. Greedily form groups starting from smallest available.
// Time: O(n log n) | Space: O(n)
import java.util.*;

class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int h : hand) count.merge(h, 1, Integer::sum);
        while (!count.isEmpty()) {
            int start = count.firstKey();
            for (int i = start; i < start + groupSize; i++) {
                if (!count.containsKey(i)) return false;
                count.merge(i, -1, Integer::sum);
                if (count.get(i) == 0) count.remove(i);
            }
        }
        return true;
    }
}
