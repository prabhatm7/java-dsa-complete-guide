/*
 * Problem: Unique Paths in m x n grid (right/down only).
 *
 * Intuition: Total moves = (m-1)+(n-1); choose (m-1) right moves => C(m+n-2, m-1).
 * Time: O(min(m,n))  Space: O(1)
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int N = m + n - 2, r = m - 1;
        double ans = 1;
        for (int i = 1; i <= r; i++) ans = ans * (N - r + i) / i;
        return (int) Math.round(ans);
    }
}
