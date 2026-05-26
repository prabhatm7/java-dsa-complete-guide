/*
 * Problem: Minimum Cost to Cut a Stick.
 *
 * Intuition: Sort cuts and add boundaries (0, n); dp[i][j] = (cuts[j]-cuts[i]) + min over k in (i,j) of dp[i][k]+dp[k][j].
 * Time: O(c^3)  Space: O(c^2)
 */
import java.util.*;
public class MinCostCutStick {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] arr = new int[c + 2];
        for (int i = 0; i < c; i++) arr[i + 1] = cuts[i];
        arr[0] = 0; arr[c + 1] = n;
        Arrays.sort(arr);
        int m = arr.length;
        int[][] dp = new int[m][m];
        for (int len = 2; len < m; len++)
            for (int i = 0; i + len < m; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++)
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                dp[i][j] += arr[j] - arr[i];
            }
        return dp[0][m - 1];
    }
}
