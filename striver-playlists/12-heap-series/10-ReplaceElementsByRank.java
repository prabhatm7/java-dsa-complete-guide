/*
 * Problem: Replace each element by its rank in array (1-indexed, ties same rank).
 *
 * Intuition: Sort copy; map value -> rank; replace.
 * Time: O(n log n)  Space: O(n)
 */
import java.util.*;
public class ReplaceElementsByRank {
    public int[] replaceByRank(int[] a) {
        int[] s = a.clone();
        Arrays.sort(s);
        Map<Integer, Integer> rank = new HashMap<>();
        int r = 0;
        for (int x : s) if (!rank.containsKey(x)) rank.put(x, ++r);
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) res[i] = rank.get(a[i]);
        return res;
    }
}
