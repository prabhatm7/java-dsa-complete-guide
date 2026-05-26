/*
 * Problem: Max sum subarray of size K.
 *
 * Intuition: Fixed window; subtract leaving, add entering.
 * Time: O(n)  Space: O(1)
 */
public class MaxSumSubarrayK {
    public int maxSum(int[] a, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) sum += a[i];
        int best = sum;
        for (int i = k; i < a.length; i++) { sum += a[i] - a[i-k]; best = Math.max(best, sum); }
        return best;
    }
}
