/*
 * Problem: Minimum Bit Flips to Convert Number.
 *
 * Intuition: XOR start and goal; count set bits.
 * Time: O(1)  Space: O(1)
 */
public class MinBitFlips {
    public int minBitFlips(int start, int goal) {
        int x = start ^ goal, c = 0;
        while (x != 0) { c += x & 1; x >>>= 1; }
        return c;
    }
}
