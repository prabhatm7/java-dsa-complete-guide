/*
 * Problem: Sum of First N numbers (recursive).
 *
 * Intuition: f(n) = n + f(n-1); base f(0) = 0.
 * Time: O(n)  Space: O(n)
 */
public class SumFirstN {
    public long sum(int n) {
        if (n == 0) return 0;
        return n + sum(n - 1);
    }
}
