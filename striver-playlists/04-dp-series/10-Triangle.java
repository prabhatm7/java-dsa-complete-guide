/*
 * Problem: Triangle — min path sum from top to bottom (moves to adjacent below).
 *
 * Intuition: Bottom-up DP — dp[j] = t[i][j] + min(dp[j], dp[j+1]).
 * Time: O(n^2)  Space: O(n)
 */
import java.util.*;
public class Triangle {
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) dp[j] = t.get(n-1).get(j);
        for (int i = n - 2; i >= 0; i--)
            for (int j = 0; j <= i; j++)
                dp[j] = t.get(i).get(j) + Math.min(dp[j], dp[j+1]);
        return dp[0];
    }
}
