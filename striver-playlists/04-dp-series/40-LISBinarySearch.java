/*
 * Problem: Longest Increasing Subsequence (O(n log n)).
 *
 * Intuition: Patience sorting — tails array; binary-search insertion point.
 * Time: O(n log n)  Space: O(n)
 */
import java.util.*;
public class LISBinarySearch {
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
