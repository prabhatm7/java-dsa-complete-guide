/*
 * Problem: Sort Colors (Dutch National Flag)
 * Sort array of 0s, 1s, and 2s in-place.
 *
 * Intuition: Three pointers low/mid/high; 0 -> swap(low,mid)++; 1 -> mid++; 2 -> swap(mid,high)--.
 * Time: O(n)  Space: O(1)
 */
public class SortColors {
    public void sortColors(int[] a) {
        int lo = 0, mid = 0, hi = a.length - 1;
        while (mid <= hi) {
            if (a[mid] == 0) { int t = a[lo]; a[lo++] = a[mid]; a[mid++] = t; }
            else if (a[mid] == 1) mid++;
            else { int t = a[mid]; a[mid] = a[hi]; a[hi--] = t; }
        }
    }
}
