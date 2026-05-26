/*
 * Problem: Single Number — every other element appears twice.
 *
 * Intuition: XOR all; duplicates cancel.
 * Time: O(n)  Space: O(1)
 */
public class SingleNumberI {
    public int singleNumber(int[] a) {
        int x = 0;
        for (int v : a) x ^= v;
        return x;
    }
}
