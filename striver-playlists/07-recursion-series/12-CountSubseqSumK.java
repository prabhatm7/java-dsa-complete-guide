/*
 * Problem: Count subsequences with sum K.
 *
 * Intuition: Same take/not-take; return 1 on success at end.
 * Time: O(2^n)  Space: O(n)
 */
public class CountSubseqSumK {
    public int count(int[] a, int k) { return go(0, a, k); }
    private int go(int i, int[] a, int k) {
        if (i == a.length) return k == 0 ? 1 : 0;
        return go(i + 1, a, k - a[i]) + go(i + 1, a, k);
    }
}
