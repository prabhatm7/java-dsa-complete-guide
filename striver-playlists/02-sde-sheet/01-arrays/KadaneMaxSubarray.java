/*
 * Problem: Maximum Subarray Sum (Kadane's Algorithm)
 * Find contiguous subarray with the largest sum.
 *
 * Intuition: Track running sum; reset to 0 when it goes negative; remember max seen.
 * Time: O(n)  Space: O(1)
 */
public class KadaneMaxSubarray {
    public int maxSubArray(int[] a) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int x : a) {
            sum += x;
            if (sum > max) max = sum;
            if (sum < 0) sum = 0;
        }
        return max;
    }
}
