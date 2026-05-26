/*
 * Problem: Minimum Window Subsequence.
 *
 * Intuition: Two-pointer; forward to match t, then backward to tighten start.
 * Time: O(n*m) worst  Space: O(1)
 */
public class MinWindowSubsequence {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0, bestL = -1, bestLen = Integer.MAX_VALUE;
        while (i < n) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
                if (j == m) {
                    int end = i + 1;
                    j--;
                    while (j >= 0) {
                        if (s.charAt(i) == t.charAt(j)) j--;
                        i--;
                    }
                    i++; j++;
                    if (end - i < bestLen) { bestLen = end - i; bestL = i; }
                }
            }
            i++;
        }
        return bestL == -1 ? "" : s.substring(bestL, bestL + bestLen);
    }
}
