/*
 * Problem: Climbing Stairs — count ways to reach n with 1 or 2 steps.
 *
 * Intuition: Fibonacci-like; f(n) = f(n-1) + f(n-2).
 * Time: O(n)  Space: O(1)
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        for (int i = 2; i <= n; i++) { int c = a + b; a = b; b = c; }
        return b;
    }
}
