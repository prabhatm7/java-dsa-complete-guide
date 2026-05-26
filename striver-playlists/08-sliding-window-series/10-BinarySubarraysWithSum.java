/*
 * Problem: Binary Subarrays With Sum exactly goal.
 *
 * Intuition: atMost(goal) - atMost(goal-1).
 * Time: O(n)  Space: O(1)
 */
public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] a, int g) {
        return atMost(a, g) - atMost(a, g - 1);
    }
    private int atMost(int[] a, int g) {
        if (g < 0) return 0;
        int l = 0, sum = 0, ans = 0;
        for (int r = 0; r < a.length; r++) {
            sum += a[r];
            while (sum > g) sum -= a[l++];
            ans += r - l + 1;
        }
        return ans;
    }
}
