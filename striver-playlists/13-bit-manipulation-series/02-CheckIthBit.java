/*
 * Problem: Check if i-th bit is set.
 *
 * Intuition: (n >> i) & 1 or n & (1 << i).
 * Time: O(1)  Space: O(1)
 */
public class CheckIthBit {
    public boolean isSet(int n, int i) { return ((n >> i) & 1) == 1; }
}
