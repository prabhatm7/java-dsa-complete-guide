/*
 * Problem: Two Missing Numbers in [1..n].
 *
 * Intuition: XOR with [1..n] to get x^y; split via diff bit.
 * Time: O(n)  Space: O(1)
 */
public class TwoMissingNumbers {
    public int[] missing(int[] a, int n) {
        int xor = 0;
        for (int i = 1; i <= n; i++) xor ^= i;
        for (int v : a) xor ^= v;
        int diff = xor & -xor;
        int x = 0, y = 0;
        for (int v : a) { if ((v & diff) == 0) x ^= v; else y ^= v; }
        for (int i = 1; i <= n; i++) { if ((i & diff) == 0) x ^= i; else y ^= i; }
        return new int[]{x, y};
    }
}
