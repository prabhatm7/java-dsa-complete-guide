/*
 * Problem: Count Squares With All 1s.
 *
 * Intuition: dp[i][j] = if mat[i][j]==1 then 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]); sum all dp.
 * Time: O(n*m)  Space: O(n*m)
 */
public class CountSquaresAll1s {
    public int countSquares(int[][] m) {
        int n = m.length, w = m[0].length, total = 0;
        int[][] dp = new int[n][w];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < w; j++) {
                if (m[i][j] == 0) continue;
                if (i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                total += dp[i][j];
            }
        return total;
    }
}
