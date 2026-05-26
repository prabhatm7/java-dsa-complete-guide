/*
 * Problem: Reverse Pairs
 * Count pairs (i,j) with i<j and a[i] > 2*a[j].
 *
 * Intuition: Modified merge sort; for each i in left half, count j in right half such that a[i] > 2*a[j].
 * Time: O(n log n)  Space: O(n)
 */
public class ReversePairs {
    public int reversePairs(int[] a) {
        return mergeSort(a, 0, a.length - 1);
    }
    private int mergeSort(int[] a, int l, int r) {
        if (l >= r) return 0;
        int m = (l + r) / 2;
        int cnt = mergeSort(a, l, m) + mergeSort(a, m + 1, r);
        int j = m + 1;
        for (int i = l; i <= m; i++) {
            while (j <= r && a[i] > 2L * a[j]) j++;
            cnt += j - (m + 1);
        }
        merge(a, l, m, r);
        return cnt;
    }
    private void merge(int[] a, int l, int m, int r) {
        int[] tmp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) tmp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= m) tmp[k++] = a[i++];
        while (j <= r) tmp[k++] = a[j++];
        for (int p = 0; p < tmp.length; p++) a[l + p] = tmp[p];
    }
}
