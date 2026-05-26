/*
 * Problem: Longest Bitonic Subsequence (increasing then decreasing).
 *
 * Intuition: Compute LIS from left and LDS from right; answer max(L[i] + R[i] - 1).
 * Time: O(n^2)  Space: O(n)
 */
public class LongestBitonicSubseq {
    public int longestBitonicSequence(int[] a) {
        int n = a.length;
        int[] L = new int[n], R = new int[n];
        for (int i = 0; i < n; i++) { L[i] = 1; for (int j = 0; j < i; j++) if (a[j] < a[i]) L[i] = Math.max(L[i], L[j] + 1); }
        for (int i = n - 1; i >= 0; i--) { R[i] = 1; for (int j = n - 1; j > i; j--) if (a[j] < a[i]) R[i] = Math.max(R[i], R[j] + 1); }
        int best = 0;
        for (int i = 0; i < n; i++) best = Math.max(best, L[i] + R[i] - 1);
        return best;
    }
}
