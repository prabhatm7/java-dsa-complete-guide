/*
 * Problem: Longest substring with K distinct chars.
 *
 * Intuition: Sliding window with HashMap count; shrink while distinct > k.
 * Time: O(n)  Space: O(k)
 */
import java.util.*;
public class LongestKDistinct {
    public int longest(String s, int k) {
        Map<Character, Integer> m = new HashMap<>();
        int l = 0, best = 0;
        for (int r = 0; r < s.length(); r++) {
            m.merge(s.charAt(r), 1, Integer::sum);
            while (m.size() > k) { char c = s.charAt(l++); if (m.merge(c, -1, Integer::sum) == 0) m.remove(c); }
            best = Math.max(best, r - l + 1);
        }
        return best;
    }
}
