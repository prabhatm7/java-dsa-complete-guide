/*
 * Problem: Longest Subarray with Sum K (handles negatives)
 *
 * Intuition: Prefix sum + HashMap of first occurrence; for each prefix p, look for p-K.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class LongestSubarraySumK {
    public int longestSubarray(int[] a, int k) {
        Map<Long, Integer> first = new HashMap<>();
        long p = 0; int best = 0;
        for (int i = 0; i < a.length; i++) {
            p += a[i];
            if (p == k) best = i + 1;
            if (first.containsKey(p - k)) best = Math.max(best, i - first.get(p - k));
            first.putIfAbsent(p, i);
        }
        return best;
    }
}
