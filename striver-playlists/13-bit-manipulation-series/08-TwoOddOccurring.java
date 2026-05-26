/*
 * Problem: Find Two Numbers Appearing Odd Number of Times.
 *
 * Intuition: XOR all => x^y; rightmost set bit splits into two groups; XOR each group.
 * Time: O(n)  Space: O(1)
 */
public class TwoOddOccurring {
    public int[] twoOdd(int[] a) {
        int xor = 0;
        for (int x : a) xor ^= x;
        int diff = xor & -xor;
        int x = 0, y = 0;
        for (int v : a) { if ((v & diff) == 0) x ^= v; else y ^= v; }
        return new int[]{x, y};
    }
}
