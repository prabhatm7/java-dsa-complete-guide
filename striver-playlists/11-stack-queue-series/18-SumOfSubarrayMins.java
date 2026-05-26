/*
 * Problem: Sum of Subarray Minimums.
 *
 * Intuition: For each i, count subarrays where a[i] is min: (i - prevSmaller) * (nextSmaller - i).
 * Time: O(n)  Space: O(n)
 */
import java.util.*;
public class SumOfSubarrayMins {
    final int MOD = (int) 1e9 + 7;
    public int sumSubarrayMins(int[] a) {
        int n = a.length;
        int[] left = new int[n], right = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] > a[i]) st.pop();
            left[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) st.pop();
            right[i] = st.isEmpty() ? n - i : st.peek() - i;
            st.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) ans = (ans + (long) a[i] * left[i] * right[i]) % MOD;
        return (int) ans;
    }
}
