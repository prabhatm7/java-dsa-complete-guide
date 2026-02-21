// LC 91. Decode Ways
// Approach: Top-down memoization. dfs(i) = number of ways to decode s[i..end].
// Single digit valid (1-9): dfs(i+1). Two digits valid (10-26): dfs(i+2).
// Time: O(n) | Space: O(n)
import java.util.*;

class DecodeWays {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int numDecodings(String s) {
        return dfs(s, 0);
    }

    private int dfs(String s, int i) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (memo.containsKey(i)) return memo.get(i);
        int ways = dfs(s, i + 1);
        if (i + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(i, i + 2));
            if (twoDigit >= 10 && twoDigit <= 26) ways += dfs(s, i + 2);
        }
        memo.put(i, ways);
        return ways;
    }
}
