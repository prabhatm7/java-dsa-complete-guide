/*
 * Problem: Sum of Subarray Ranges (max - min over each subarray).
 *
 * Intuition: Sum of max over subarrays minus sum of min using monotonic stack.
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class SumOfSubarrayRanges {
    public long subArrayRanges(int[] a) {
        return contribution(a, false) - contribution(a, true);
    }
    private long contribution(int[] a, boolean isMin) {
        int n = a.length;
        long total = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || (isMin ? a[st.peek()] > a[i] : a[st.peek()] < a[i]))) {
                int j = st.pop();
                int k = st.isEmpty() ? -1 : st.peek();
                total += (long) a[j] * (i - j) * (j - k);
            }
            st.push(i);
        }
        return total;
    }
}
