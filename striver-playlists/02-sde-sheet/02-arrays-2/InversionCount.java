/*
 * Problem: Count Inversions
 * Number of pairs (i,j) with i<j and a[i]>a[j].
 *
 * Intuition: Merge sort: during merge, if a[i] > a[j], all remaining in left half form inversions with a[j].
 * Time: O(n log n)  Space: O(n)
 */
public class InversionCount {
    public long inversionCount(long[] a) {
        return mergeSort(a, 0, a.length - 1);
    }
    private long mergeSort(long[] a, int l, int r) {
        if (l >= r) return 0;
        int mid = (l + r) / 2;
        long inv = mergeSort(a, l, mid) + mergeSort(a, mid + 1, r);
        inv += merge(a, l, mid, r);
        return inv;
    }
    private long merge(long[] a, int l, int m, int r) {
        long[] tmp = new long[r - l + 1];
        int i = l, j = m + 1, k = 0; long cnt = 0;
        while (i <= m && j <= r) {
            if (a[i] <= a[j]) tmp[k++] = a[i++];
            else { tmp[k++] = a[j++]; cnt += (m - i + 1); }
        }
        while (i <= m) tmp[k++] = a[i++];
        while (j <= r) tmp[k++] = a[j++];
        for (int p = 0; p < tmp.length; p++) a[l + p] = tmp[p];
        return cnt;
    }
}
