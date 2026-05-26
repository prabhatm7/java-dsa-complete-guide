/*
 * Problem: Longest String Chain.
 *
 * Intuition: Sort by length; for each word try removing each char; if predecessor in dp, dp[w] = dp[pred] + 1.
 * Time: O(n*L^2)  Space: O(n)
 */
import java.util.*;
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<>();
        int best = 0;
        for (String w : words) {
            int cur = 1;
            for (int i = 0; i < w.length(); i++) {
                String pre = w.substring(0, i) + w.substring(i + 1);
                cur = Math.max(cur, dp.getOrDefault(pre, 0) + 1);
            }
            dp.put(w, cur);
            best = Math.max(best, cur);
        }
        return best;
    }
}
