// LC 139. Word Break
// Approach: Top-down memoization. dfs(i) = can s[i..end] be segmented into dict words?
// Try every prefix s[i..j); if in dict and dfs(j) is true, return true.
// Time: O(n^2 * m) | Space: O(n)
import java.util.*;

class WordBreak {
    private Map<Integer, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return dfs(s, 0, dict);
    }

    private boolean dfs(String s, int i, Set<String> dict) {
        if (i == s.length()) return true;
        if (memo.containsKey(i)) return memo.get(i);
        for (int j = i + 1; j <= s.length(); j++) {
            if (dict.contains(s.substring(i, j)) && dfs(s, j, dict)) {
                memo.put(i, true);
                return true;
            }
        }
        memo.put(i, false);
        return false;
    }
}
