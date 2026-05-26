/*
 * Problem: Longest Increasing Subsequence.
 *
 * Intuition: Patience sorting — maintain tails array; binary-search insertion point; length = len(tails).
 * Time: O(n log n)  Space: O(n)
 */
import java.util.*;
public class LIS {
    public int lengthOfLIS(int[] a) {
        int[] t = new int[a.length]; int len = 0;
        for (int x : a) {
            int i = Arrays.binarySearch(t, 0, len, x);
            if (i < 0) i = -(i + 1);
            t[i] = x;
            if (i == len) len++;
        }
        return len;
    }
}
