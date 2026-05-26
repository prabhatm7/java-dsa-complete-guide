/*
 * Problem: Word Break — can s be segmented into dictionary words?
 *
 * Intuition: dp[i] = true if s[0..i] segmentable; check j<i with dp[j] && dict contains s[j..i].
 * Time: O(n^2)  Space: O(n)
 */
import java.util.*;
public class WordBreakDP {
    public boolean wordBreak(String s, List<String> dict) {
        Set<String> d = new HashSet<>(dict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++)
            for (int j = 0; j < i; j++)
                if (dp[j] && d.contains(s.substring(j, i))) { dp[i] = true; break; }
        return dp[s.length()];
    }
}
