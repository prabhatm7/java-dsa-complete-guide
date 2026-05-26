/*
 * Problem: Factorial of N.
 *
 * Intuition: f(n) = n * f(n-1); f(0) = 1.
 * Time: O(n)  Space: O(n)
 */
public class FactorialN {
    public long factorial(int n) { return n <= 1 ? 1 : n * factorial(n - 1); }
}
