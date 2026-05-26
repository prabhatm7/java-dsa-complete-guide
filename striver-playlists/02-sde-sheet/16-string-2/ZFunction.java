/*
 * Problem: Z-function — z[i] = length of longest substring starting at i that matches prefix.
 *
 * Intuition: Maintain window [l,r] of rightmost match; reuse previously computed z values.
 * Time: O(n)  Space: O(n)
 */
public class ZFunction {
    public int[] zFunction(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i < r) z[i] = Math.min(r - i, z[i - l]);
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) z[i]++;
            if (i + z[i] > r) { l = i; r = i + z[i]; }
        }
        return z;
    }
}
