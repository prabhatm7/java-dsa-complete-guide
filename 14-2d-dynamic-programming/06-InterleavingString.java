// LC 97. Interleaving String
// Approach: Top-down memoization. dfs(i, j) = can s1[i..] and s2[j..] interleave to form s3[i+j..]?
// If s1[i] matches s3[i+j]: try advancing i. If s2[j] matches: try advancing j.
// Time: O(m*n) | Space: O(m*n)
class InterleavingString {
    private Boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(s1, s2, s3, 0, 0);
    }

    private boolean dfs(String s1, String s2, String s3, int i, int j) {
        if (i == s1.length() && j == s2.length()) return true;
        if (memo[i][j] != null) return memo[i][j];
        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j))
            res = dfs(s1, s2, s3, i + 1, j);
        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(i + j))
            res = dfs(s1, s2, s3, i, j + 1);
        memo[i][j] = res;
        return res;
    }
}
