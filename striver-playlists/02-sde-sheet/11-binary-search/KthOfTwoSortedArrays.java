/*
 * Problem: Kth element of two sorted arrays (merged).
 *
 * Intuition: BS partition; left side must have exactly k elements; pick i from smaller array.
 * Time: O(log(min(n,m)))  Space: O(1)
 */
public class KthOfTwoSortedArrays {
    public int kthElement(int[] a, int[] b, int k) {
        if (a.length > b.length) return kthElement(b, a, k);
        int n = a.length, m = b.length;
        int lo = Math.max(0, k - m), hi = Math.min(k, n);
        while (lo <= hi) {
            int i = (lo + hi) / 2, j = k - i;
            int aL = i == 0 ? Integer.MIN_VALUE : a[i-1];
            int aR = i == n ? Integer.MAX_VALUE : a[i];
            int bL = j == 0 ? Integer.MIN_VALUE : b[j-1];
            int bR = j == m ? Integer.MAX_VALUE : b[j];
            if (aL <= bR && bL <= aR) return Math.max(aL, bL);
            else if (aL > bR) hi = i - 1; else lo = i + 1;
        }
        return -1;
    }
}
