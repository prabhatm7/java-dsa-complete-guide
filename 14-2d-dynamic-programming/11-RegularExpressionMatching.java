// LC 10. Regular Expression Matching
// Approach: Top-down memoization. dfs(i, j) = does s[i..] match p[j..]?
// '.': matches any single char. '*': zero or more of preceding element.
// If p[j+1] == '*': try zero matches dfs(i, j+2) or one match + recurse dfs(i+1, j) if s[i] matches p[j].
// Time: O(m*n) | Space: O(m*n)
class RegularExpressionMatching {
    private Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(s, p, 0, 0);
    }

    private boolean dfs(String s, String p, int i, int j) {
        if (j == p.length()) return i == s.length();
        if (memo[i][j] != null) return memo[i][j];

        boolean firstMatch = i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));

        if (j + 1 < p.length() && p.charAt(j + 1) == '*')
            memo[i][j] = dfs(s, p, i, j + 2) ||             // zero matches
                          (firstMatch && dfs(s, p, i + 1, j)); // one+ matches
        else
            memo[i][j] = firstMatch && dfs(s, p, i + 1, j + 1);

        return memo[i][j];
    }
}
