/*
 * Problem: Merge Two Sorted Arrays Without Extra Space
 * Place first n smallest in a, remaining in b, both sorted.
 *
 * Intuition: Gap method (Shell-sort like) — compare elements at gap distance across both arrays, swap if out of order; halve gap.
 * Time: O((n+m) log(n+m))  Space: O(1)
 */
public class MergeTwoSortedArrays {
    public void merge(long[] a, long[] b, int n, int m) {
        int len = n + m;
        int gap = (len + 1) / 2;
        while (gap > 0) {
            int l = 0, r = l + gap;
            while (r < len) {
                if (l < n && r < n) { if (a[l] > a[r]) swap(a, l, a, r); }
                else if (l < n && r >= n) { if (a[l] > b[r - n]) swap(a, l, b, r - n); }
                else { if (b[l - n] > b[r - n]) swap(b, l - n, b, r - n); }
                l++; r++;
            }
            if (gap == 1) break;
            gap = (gap + 1) / 2;
        }
    }
    private void swap(long[] x, int i, long[] y, int j) { long t = x[i]; x[i] = y[j]; y[j] = t; }
}
