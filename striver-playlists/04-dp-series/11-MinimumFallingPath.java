/*
 * Problem: Minimum/Maximum Falling Path Sum in matrix (can move to 3 adjacent below).
 *
 * Intuition: dp[i][j] = m[i][j] + min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1]); answer = min of last row.
 * Time: O(n*m)  Space: O(m)
 */
public class MinimumFallingPath {
    public int minFallingPathSum(int[][] m) {
        int n = m.length, w = m[0].length;
        int[] prev = m[0].clone();
        for (int i = 1; i < n; i++) {
            int[] cur = new int[w];
            for (int j = 0; j < w; j++) {
                int a = prev[j];
                int b = j > 0 ? prev[j-1] : Integer.MAX_VALUE;
                int c = j+1 < w ? prev[j+1] : Integer.MAX_VALUE;
                cur[j] = m[i][j] + Math.min(a, Math.min(b, c));
            }
            prev = cur;
        }
        int ans = Integer.MAX_VALUE;
        for (int v : prev) ans = Math.min(ans, v);
        return ans;
    }
}
