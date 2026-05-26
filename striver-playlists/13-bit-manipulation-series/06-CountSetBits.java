/*
 * Problem: Count set bits (Brian Kernighan's).
 *
 * Intuition: n & (n-1) clears the lowest set bit; count iterations.
 * Time: O(set bits)  Space: O(1)
 */
public class CountSetBits {
    public int count(int n) {
        int c = 0;
        while (n != 0) { n &= (n - 1); c++; }
        return c;
    }
}
