/*
 * Problem: Minimum Window Substring containing all chars of t.
 *
 * Intuition: Need-map; expand r; when all needs met, shrink l for minimum.
 * Time: O(n+m)  Space: O(charset)
 */
public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] need = new int[128];
        for (char c : t.toCharArray()) need[c]++;
        int required = t.length(), l = 0, bestL = 0, bestLen = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++) {
            if (need[s.charAt(r)]-- > 0) required--;
            while (required == 0) {
                if (r - l + 1 < bestLen) { bestLen = r - l + 1; bestL = l; }
                if (++need[s.charAt(l++)] > 0) required++;
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestL, bestL + bestLen);
    }
}
