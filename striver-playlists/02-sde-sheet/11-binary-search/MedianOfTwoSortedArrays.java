/*
 * Problem: Median of Two Sorted Arrays.
 *
 * Intuition: BS partition on smaller array; pick cut so left has (n+m+1)/2 elements; ensure maxLeft<=minRight.
 * Time: O(log(min(n,m)))  Space: O(1)
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length) return findMedianSortedArrays(b, a);
        int n = a.length, m = b.length, total = n + m, half = (total + 1) / 2;
        int lo = 0, hi = n;
        while (lo <= hi) {
            int i = (lo + hi) / 2, j = half - i;
            int aL = i == 0 ? Integer.MIN_VALUE : a[i-1];
            int aR = i == n ? Integer.MAX_VALUE : a[i];
            int bL = j == 0 ? Integer.MIN_VALUE : b[j-1];
            int bR = j == m ? Integer.MAX_VALUE : b[j];
            if (aL <= bR && bL <= aR) {
                if (total % 2 == 1) return Math.max(aL, bL);
                return (Math.max(aL, bL) + Math.min(aR, bR)) / 2.0;
            } else if (aL > bR) hi = i - 1; else lo = i + 1;
        }
        return 0;
    }
}
