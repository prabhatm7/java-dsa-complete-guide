/*
 * Problem: Next Permutation
 * Rearrange array into lexicographically next greater permutation. If none, sort ascending.
 *
 * Intuition: Find first i from right where a[i]<a[i+1] (break point); swap with smallest greater on right; reverse suffix.
 * Time: O(n)  Space: O(1)
 */
public class NextPermutation {
    public void nextPermutation(int[] a) {
        int n = a.length, i = n - 2;
        while (i >= 0 && a[i] >= a[i+1]) i--;
        if (i >= 0) {
            int j = n - 1;
            while (a[j] <= a[i]) j--;
            swap(a, i, j);
        }
        reverse(a, i + 1, n - 1);
    }
    private void swap(int[] a, int i, int j) { int t = a[i]; a[i] = a[j]; a[j] = t; }
    private void reverse(int[] a, int l, int r) { while (l < r) swap(a, l++, r--); }
}
