/*
 * Problem: Print the LCS.
 *
 * Intuition: Build dp table; backtrack from dp[n][m] adding matched chars; reverse.
 * Time: O(n*m)  Space: O(n*m)
 */
public class PrintLCS {
    public String printLCS(String a, String b) {
        int n = a.length(), m = b.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                dp[i][j] = a.charAt(i-1) == b.charAt(j-1) ? 1 + dp[i-1][j-1] : Math.max(dp[i-1][j], dp[i][j-1]);
        StringBuilder sb = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (a.charAt(i-1) == b.charAt(j-1)) { sb.append(a.charAt(i-1)); i--; j--; }
            else if (dp[i-1][j] > dp[i][j-1]) i--; else j--;
        }
        return sb.reverse().toString();
    }
}
