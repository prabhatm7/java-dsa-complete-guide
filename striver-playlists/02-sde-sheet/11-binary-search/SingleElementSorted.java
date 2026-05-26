/*
 * Problem: Single Element in a Sorted Array (every other appears twice).
 *
 * Intuition: Pair index parity changes at the single element; BS with mid XOR 1 trick.
 * Time: O(log n)  Space: O(1)
 */
public class SingleElementSorted {
    public int singleNonDuplicate(int[] a) {
        int lo = 0, hi = a.length - 2;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] == a[mid ^ 1]) lo = mid + 1; else hi = mid - 1;
        }
        return a[lo];
    }
}
