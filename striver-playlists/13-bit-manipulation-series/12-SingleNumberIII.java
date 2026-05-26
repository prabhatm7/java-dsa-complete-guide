/*
 * Problem: Single Number III — two unique elements, others appear twice.
 *
 * Intuition: XOR all to get x^y; isolate a diff bit; split into two groups.
 * Time: O(n)  Space: O(1)
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] a) {
        int xor = 0;
        for (int v : a) xor ^= v;
        int diff = xor & -xor;
        int x = 0, y = 0;
        for (int v : a) { if ((v & diff) == 0) x ^= v; else y ^= v; }
        return new int[]{x, y};
    }
}
