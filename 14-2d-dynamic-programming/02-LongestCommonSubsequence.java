// LC 1143. Longest Common Subsequence
// Approach: Top-down memoization. dfs(i, j) = LCS of text1[i..] and text2[j..].
// If chars match: 1 + dfs(i+1, j+1). Else: max(dfs(i+1, j), dfs(i, j+1)).
// Time: O(m*n) | Space: O(m*n)
class LongestCommonSubsequence {
    private Integer[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new Integer[text1.length()][text2.length()];
        return dfs(text1, text2, 0, 0);
    }

    private int dfs(String s1, String s2, int i, int j) {
        if (i == s1.length() || j == s2.length()) return 0;
        if (memo[i][j] != null) return memo[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            memo[i][j] = 1 + dfs(s1, s2, i + 1, j + 1);
        else
            memo[i][j] = Math.max(dfs(s1, s2, i + 1, j), dfs(s1, s2, i, j + 1));
        return memo[i][j];
    }
}
