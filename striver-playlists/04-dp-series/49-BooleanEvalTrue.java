/*
 * Problem: Ways to evaluate boolean expression to True.
 *
 * Intuition: dp[i][j][isTrue] — recurse on each operator, combine left/right true/false counts.
 * Time: O(n^3)  Space: O(n^2)
 */
public class BooleanEvalTrue {
    final int MOD = 1003;
    Integer[][][] memo;
    public int evaluateExp(String s) {
        int n = s.length();
        memo = new Integer[n][n][2];
        return go(s, 0, n - 1, 1);
    }
    private int go(String s, int i, int j, int isTrue) {
        if (i > j) return 0;
        if (i == j) {
            if (isTrue == 1) return s.charAt(i) == 'T' ? 1 : 0;
            return s.charAt(i) == 'F' ? 1 : 0;
        }
        if (memo[i][j][isTrue] != null) return memo[i][j][isTrue];
        int ways = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {
            int lT = go(s, i, k - 1, 1), lF = go(s, i, k - 1, 0);
            int rT = go(s, k + 1, j, 1), rF = go(s, k + 1, j, 0);
            char op = s.charAt(k);
            if (op == '&') ways = (ways + (isTrue == 1 ? lT * rT : lT * rF + lF * rT + lF * rF)) % MOD;
            else if (op == '|') ways = (ways + (isTrue == 1 ? lT * rT + lT * rF + lF * rT : lF * rF)) % MOD;
            else ways = (ways + (isTrue == 1 ? lT * rF + lF * rT : lT * rT + lF * rF)) % MOD;
        }
        return memo[i][j][isTrue] = ways;
    }
}
