/*
 * Problem: Longest Substring Without Repeating Characters
 *
 * Intuition: Sliding window with HashMap of last index; jump left pointer past duplicate.
 * Time: O(n)  Space: O(min(n, alphabet))
 */
import java.util.*;
public class LongestSubstringNoRepeat {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> last = new HashMap<>();
        int l = 0, best = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (last.containsKey(c) && last.get(c) >= l) l = last.get(c) + 1;
            last.put(c, r);
            if (r - l + 1 > best) best = r - l + 1;
        }
        return best;
    }
}
