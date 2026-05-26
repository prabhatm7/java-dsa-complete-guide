/*
 * Problem: House Robber — max sum no two adjacent.
 *
 * Intuition: dp[i] = max(dp[i-1], dp[i-2] + a[i]).
 * Time: O(n)  Space: O(1)
 */
public class HouseRobber {
    public int rob(int[] a) {
        int p2 = 0, p1 = 0;
        for (int x : a) { int c = Math.max(p1, p2 + x); p2 = p1; p1 = c; }
        return p1;
    }
}
