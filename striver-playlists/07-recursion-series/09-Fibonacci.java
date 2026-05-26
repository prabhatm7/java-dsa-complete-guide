/*
 * Problem: Nth Fibonacci number.
 *
 * Intuition: f(n) = f(n-1) + f(n-2); f(0)=0, f(1)=1. Naïve recursion is O(2^n); memoize for O(n).
 * Time: O(2^n) naive / O(n) memo  Space: O(n)
 */
public class Fibonacci {
    public int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
}
