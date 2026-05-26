/*
 * Problem: Count Number of Nice Subarrays (k odd numbers).
 *
 * Intuition: atMost(k) - atMost(k-1) on odd-count.
 * Time: O(n)  Space: O(1)
 */
public class CountNiceSubarrays {
    public int numberOfSubarrays(int[] a, int k) {
        return atMost(a, k) - atMost(a, k - 1);
    }
    private int atMost(int[] a, int k) {
        if (k < 0) return 0;
        int l = 0, odd = 0, ans = 0;
        for (int r = 0; r < a.length; r++) {
            if ((a[r] & 1) == 1) odd++;
            while (odd > k) if ((a[l++] & 1) == 1) odd--;
            ans += r - l + 1;
        }
        return ans;
    }
}
