// LC 72. Edit Distance
// Approach: Top-down memoization. dfs(i, j) = min ops to convert word1[i..] to word2[j..].
// If chars match: dfs(i+1, j+1). Else: 1 + min(insert dfs(i,j+1), delete dfs(i+1,j), replace dfs(i+1,j+1)).
// Time: O(m*n) | Space: O(m*n)
class EditDistance {
    private Integer[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new Integer[word1.length() + 1][word2.length() + 1];
        return dfs(word1, word2, 0, 0);
    }

    private int dfs(String w1, String w2, int i, int j) {
        if (i == w1.length()) return w2.length() - j;
        if (j == w2.length()) return w1.length() - i;
        if (memo[i][j] != null) return memo[i][j];
        if (w1.charAt(i) == w2.charAt(j))
            memo[i][j] = dfs(w1, w2, i + 1, j + 1);
        else
            memo[i][j] = 1 + Math.min(
                dfs(w1, w2, i, j + 1),     // insert
                Math.min(
                    dfs(w1, w2, i + 1, j),     // delete
                    dfs(w1, w2, i + 1, j + 1)  // replace
                )
            );
        return memo[i][j];
    }
}
