/*
 * Problem: Word Break — can s be segmented into dictionary words?
 *
 * Intuition: DP[i] = true if s[0..i-1] segmentable; check all prefixes and dp[j] && dict.contains(s[j..i-1]).
 * Time: O(n^2)  Space: O(n)
 */
import java.util.*;
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> d = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++)
            for (int j = 0; j < i; j++)
                if (dp[j] && d.contains(s.substring(j, i))) { dp[i] = true; break; }
        return dp[s.length()];
    }
}
