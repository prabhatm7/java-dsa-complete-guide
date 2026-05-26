/*
 * Problem: Remove Duplicates from Sorted Array
 *
 * Intuition: Two pointers; write index advances only when a new value found.
 * Time: O(n)  Space: O(1)
 */
public class RemoveDuplicatesSorted {
    public int removeDuplicates(int[] a) {
        if (a.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < a.length; j++)
            if (a[j] != a[i]) a[++i] = a[j];
        return i + 1;
    }
}
