/*
 * Problem: XOR of numbers 1 to n.
 *
 * Intuition: Pattern based on n % 4: 0->n, 1->1, 2->n+1, 3->0.
 * Time: O(1)  Space: O(1)
 */
public class XorRange {
    public int xorTo(int n) {
        switch (n % 4) {
            case 0: return n;
            case 1: return 1;
            case 2: return n + 1;
            default: return 0;
        }
    }
    public int xorRange(int l, int r) {
        return xorTo(r) ^ xorTo(l - 1);
    }
}
