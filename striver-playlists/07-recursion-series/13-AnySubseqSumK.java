/*
 * Problem: Check if ANY subsequence has sum K.
 *
 * Intuition: Take/not-take; short-circuit return on success.
 * Time: O(2^n)  Space: O(n)
 */
public class AnySubseqSumK {
    public boolean exists(int[] a, int k) { return go(0, a, k); }
    private boolean go(int i, int[] a, int k) {
        if (i == a.length) return k == 0;
        if (go(i + 1, a, k - a[i])) return true;
        return go(i + 1, a, k);
    }
}
