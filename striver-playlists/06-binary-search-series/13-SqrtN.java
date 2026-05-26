/*
 * Problem: Integer square root of n.
 *
 * Intuition: BS in [0..n]; find max x where x*x <= n.
 * Time: O(log n)  Space: O(1)
 */
public class SqrtN {
    public int mySqrt(int n) {
        long lo = 0, hi = n, ans = 0;
        while (lo <= hi) {
            long m = (lo + hi) >>> 1;
            if (m * m <= n) { ans = m; lo = m + 1; }
            else hi = m - 1;
        }
        return (int) ans;
    }
}
