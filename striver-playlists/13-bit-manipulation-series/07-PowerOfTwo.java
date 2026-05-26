/*
 * Problem: Check if a number is a power of two.
 *
 * Intuition: Power of 2 has exactly one set bit: n > 0 && (n & (n-1)) == 0.
 * Time: O(1)  Space: O(1)
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) { return n > 0 && (n & (n - 1)) == 0; }
}
