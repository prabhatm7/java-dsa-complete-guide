/*
 * Problem: Longest substring without repeating characters.
 *
 * Intuition: Sliding window with last-index map; jump l to lastIdx+1.
 * Time: O(n)  Space: O(charset)
 */
import java.util.*;
public class LongestNoRepeating {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[256];
        Arrays.fill(last, -1);
        int l = 0, best = 0;
        for (int r = 0; r < s.length(); r++) {
            if (last[s.charAt(r)] >= l) l = last[s.charAt(r)] + 1;
            last[s.charAt(r)] = r;
            best = Math.max(best, r - l + 1);
        }
        return best;
    }
}
