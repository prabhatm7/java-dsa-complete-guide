/*
 * Problem: Longest Common Substring.
 *
 * Intuition: dp[i][j] = if match 1+dp[i-1][j-1] else 0; track max.
 * Time: O(n*m)  Space: O(m)
 */
public class LongestCommonSubstring {
    public int longestCommonSubstr(String a, String b) {
        int n = a.length(), m = b.length(), best = 0;
        int[] prev = new int[m+1];
        for (int i = 1; i <= n; i++) {
            int[] cur = new int[m+1];
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) { cur[j] = 1 + prev[j-1]; if (cur[j] > best) best = cur[j]; }
            }
            prev = cur;
        }
        return best;
    }
}
