/*
 * Problem: Reverse an Array using recursion.
 *
 * Intuition: Swap a[l], a[r], recurse with l+1, r-1.
 * Time: O(n)  Space: O(n)
 */
public class ReverseArray {
    public void reverse(int[] a, int l, int r) {
        if (l >= r) return;
        int t = a[l]; a[l] = a[r]; a[r] = t;
        reverse(a, l + 1, r - 1);
    }
}
