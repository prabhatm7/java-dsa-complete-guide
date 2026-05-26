/*
 * Problem: Word Break — segment s using dict.
 *
 * Intuition: For each prefix in dict, recurse on rest; memoize.
 * Time: O(n^2 * L)  Space: O(n)
 */
import java.util.*;
public class WordBreak {
    public boolean wordBreak(String s, List<String> dict) {
        Set<String> d = new HashSet<>(dict);
        Boolean[] memo = new Boolean[s.length()];
        return go(0, s, d, memo);
    }
    private boolean go(int i, String s, Set<String> d, Boolean[] memo) {
        if (i == s.length()) return true;
        if (memo[i] != null) return memo[i];
        for (int j = i + 1; j <= s.length(); j++)
            if (d.contains(s.substring(i, j)) && go(j, s, d, memo)) return memo[i] = true;
        return memo[i] = false;
    }
}
