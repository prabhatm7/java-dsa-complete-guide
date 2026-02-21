// LC 50. Pow(x, n)
// Approach: Fast exponentiation. x^n = (x^2)^(n/2). Handle negative n.
// Time: O(log n) | Space: O(1)
class PowXN {
    public double myPow(double x, int n) {
        long power = n;
        if (power < 0) { x = 1 / x; power = -power; }
        double result = 1;
        while (power > 0) {
            if ((power & 1) == 1) result *= x;
            x *= x;
            power >>= 1;
        }
        return result;
    }
}
