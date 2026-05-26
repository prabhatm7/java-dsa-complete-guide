/*
 * Problem: Maximum Product Subarray.
 *
 * Intuition: Track both max and min ending here (negatives can flip); update with new x or x * prev.
 * Time: O(n)  Space: O(1)
 */
public class MaxProductSubarray {
    public int maxProduct(int[] a) {
        int mx = a[0], mn = a[0], best = a[0];
        for (int i = 1; i < a.length; i++) {
            int x = a[i];
            int newMx = Math.max(x, Math.max(x * mx, x * mn));
            int newMn = Math.min(x, Math.min(x * mx, x * mn));
            mx = newMx; mn = newMn;
            if (mx > best) best = mx;
        }
        return best;
    }
}
