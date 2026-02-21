// LC 115. Distinct Subsequences
// Approach: Top-down memoization. dfs(i, j) = num subsequences of s[i..] matching t[j..].
// If s[i]==t[j]: dfs(i+1, j+1) + dfs(i+1, j) (use char or skip it).
// Else: dfs(i+1, j) (skip char in s).
// Time: O(m*n) | Space: O(m*n)
class DistinctSubsequences {
    private Integer[][] memo;

    public int numDistinct(String s, String t) {
        memo = new Integer[s.length() + 1][t.length() + 1];
        return dfs(s, t, 0, 0);
    }

    private int dfs(String s, String t, int i, int j) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;
        if (memo[i][j] != null) return memo[i][j];
        int res = dfs(s, t, i + 1, j); // skip s[i]
        if (s.charAt(i) == t.charAt(j))
            res += dfs(s, t, i + 1, j + 1); // use s[i] to match t[j]
        memo[i][j] = res;
        return res;
    }
}
