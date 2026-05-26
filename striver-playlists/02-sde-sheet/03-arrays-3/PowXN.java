/*
 * Problem: Pow(x, n) — implement x raised to power n.
 *
 * Intuition: Binary exponentiation; if n odd subtract 1 and multiply result by x; else x *= x, n /= 2.
 * Time: O(log n)  Space: O(1)
 */
public class PowXN {
    public double myPow(double x, int n) {
        long nn = n; double ans = 1.0;
        if (nn < 0) nn = -nn;
        while (nn > 0) {
            if ((nn & 1) == 1) { ans *= x; nn--; }
            else { x *= x; nn >>= 1; }
        }
        return n < 0 ? 1.0 / ans : ans;
    }
}
